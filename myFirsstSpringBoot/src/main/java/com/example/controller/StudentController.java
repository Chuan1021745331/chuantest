package com.example.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.StudentRepository;
import com.example.pojo.Student;

@RestController
@SpringBootConfiguration
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Student save(@Valid Student student,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			System.out.println("hello");
			return null;
		}
		System.out.println();
		return studentRepository.save(student);
	}
	
	@GetMapping("/students")
	public List<Student> getStudentList(){
		return studentRepository.findAll();
	}
	
	@GetMapping("student/{age}")
	public List<Student> getStudentByAge(@PathVariable int age){
		return studentRepository.findByAge(age);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
            	File tempFile=new File(file.getOriginalFilename());
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(tempFile));
                out.write(file.getBytes());
                System.out.println("存储路径\t:"+tempFile.getAbsolutePath());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }
	
}
