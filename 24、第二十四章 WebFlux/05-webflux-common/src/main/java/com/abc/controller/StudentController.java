package com.abc.controller;

import com.abc.bean.Student;
import com.abc.repository.StudentRepository;
import com.abc.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@GetMapping("/all")
	public Flux<Student> getAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/sse/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> getAllSSE() {
		return repository.findAll();
	}

	@PostMapping("/save")
	public Mono<Student> saveHandle(@Valid @RequestBody Student student) {
		// 验证姓名的合法性
		ValidateUtil.valideName(student.getName());
		return repository.save(student);
	}

	// 无状态删除
	@DeleteMapping("/delcommon/{id}")
	public Mono<Void> delCommonHandle(@PathVariable("id") String id) {
		return repository.deleteById(id);
	}

	// 有状态删除
	// 需求：若删除的对象存在，且删除成功，则返回响应码200，否则返回响应码404
	// ResponseEntity用于封装两类信息：响应数据对象与响应码，其泛型用于指定响应数据对象类型
	// map()与flatMap()均可做映射，但这两个方法与Stream编程中的两个同名方法没有任何关系
	// map()：同步方法
	// flatMap()：异步方法
	// 一般选择的标准是：若映射的内容中包含有耗时方法，则选择flatMap()，否则选择map()
	@DeleteMapping("/delstat/{id}")
	public Mono<ResponseEntity<Void>> delStatusHandle(@PathVariable("id") String id) {
		return repository.findById(id) // 根据id查询，若找到了指定id的对象，则返回一个Mono序列，其元素为查找到的对象
				// flatMap() 对前面findById(id)的结果做映射，即对Mono序列中的元素做映射，其参数类型为Function，即为一个输入一个输出。
				// 该映射是将一个stu对象映射一个删除操作，而delete()方法没有返回值，所以通过then()方法为其添加一个返回值
				// flatMap()：一般情况下，若要将元素映射为一个操作，则使用flatMap（），可以使操作异步执行
				// map（）：若仅是将元素映射为另一种类型，则使用map（），同步执行
				.flatMap(stu -> repository.delete(stu).
						then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				// 若findById()返回的Mono序列中没有元素，则执行defaultIfEmpty（）方法
				// defaultIfEmpty（）方法的参数是ResponseEntity类型，返回值为Mono<ResponseEntity<?>>
				.defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}

	// 修改操作
	// 需求：若修改成功，则返回修改后的对象数据及200；若指定的id对象不存在，则返回404
	@PutMapping("/update/{id}")
	public Mono<ResponseEntity<Student>> updateHanel(@PathVariable("id") String id,
													 @Valid @RequestBody Student student ) {
		// 验证姓名的合法性
		ValidateUtil.valideName(student.getName());
		return repository.findById(id)
				.flatMap(stu -> {
					stu.setName(student.getName());
					stu.setAge(student.getAge());
					return repository.save(stu);
				})
				// flatMap 的返回值类型为 Mono<Student>，即序列中的元素为Student类型，而该处理器要求返回值类型为
				// Mono<ResponseEntity<Student>>，即序列中的元素为ResponseEntity<Student>，所以需要将序列中的
				// 元素类型映射为ResponseEntity<Student>类型，所以需要调用map方法进行映射
				.map(stu -> new ResponseEntity<Student>(stu, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<Student>(HttpStatus.NOT_FOUND));
	}

	// 根据id查询
	// 需求：若查询成功，则返回指定id的对象及200；若指定的id对象不存在，则返回404
	@GetMapping("/find/{id}")
	public Mono<ResponseEntity<Student>> findHandle(@PathVariable("id") String id) {
		return repository.findById(id)
				.map(stu -> new ResponseEntity<Student>(stu, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<Student>(HttpStatus.NOT_FOUND));
	}

	// 根据年龄查询（普通返回）
	@GetMapping("/age/{below}/{up}")
	public Flux<Student> findByAgeHandle(@PathVariable("below") int below, @PathVariable("up") int up) {
		return repository.findByAgeBetween(below, up);
	}

	// 根据年龄查询（普通返回）
	@GetMapping(value = "/sse/age/{below}/{up}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> findByAgeSSEHandle(@PathVariable("below") int below, @PathVariable("up") int up) {
		return repository.findByAgeBetween(below, up);
	}

	// 根据年龄查询（普通返回）
	@GetMapping("/find/age/{below}/{up}")
	public Flux<Student> findByAgeHandle2(@PathVariable("below") int below, @PathVariable("up") int up) {
		return repository.findByAge(below, up);
	}

	// 根据年龄查询（普通返回）
	@GetMapping(value = "/sse/find/age/{below}/{up}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Student> findByAgeSSEHandle2(@PathVariable("below") int below, @PathVariable("up") int up) {
		return repository.findByAge(below, up);
	}
}



























