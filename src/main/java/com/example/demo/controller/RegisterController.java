package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.RegisterForm;
import com.example.demo.helper.RegisterHelper;
import com.example.demo.service.RegisterService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	/**DI*/
	private final RegisterService registerService;
	
	@GetMapping
	public String showRegisterForm(Model model) {
	    model.addAttribute("registerForm", new RegisterForm());
	    return "register";
	}

	    @PostMapping
	    public String processRegister(
	            @Valid RegisterForm registerForm,
	            BindingResult bindingResult, 
	            Model model,
	            RedirectAttributes attributes) {
	    	

	     // ユーザー名の重複チェック
	        if (registerService.findByUsername(registerForm.getUsernameInput()) != null) {
	            bindingResult.rejectValue("usernameInput", "error.userForm", "このユーザー名は既に使用されています。");
	        }

	        if (bindingResult.hasErrors()) {
	            return "register";
	        }
	        
	        // ユーザー登録処理
	        registerService.registerUser(RegisterHelper.convertUser(registerForm));
	        
	        attributes.addFlashAttribute("message","ユーザー登録に成功しました");
	        return "redirect:/login"; // 登録成功後にログインページへリダイレクト
	    }
	
}
