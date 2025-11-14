package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.CopingStrategy;
import com.example.demo.form.CopingForm;
import com.example.demo.helper.CopingHelper;
import com.example.demo.service.CopingService;
import com.example.demo.service.UserSessionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/coping")
@RequiredArgsConstructor
public class CopingController {
	/**DI*/
	private final CopingService copingService;
	private final UserSessionService userSessionService;

	/**ユーザーのコーピング一覧を表示する*/
	@GetMapping
	public String list(Model model, HttpSession session) {
		// セッションからユーザーIDを取得、なければ認証から取得
		userSessionService.ensureUserSession(session);

		// サービス呼び出しの前にnullチェック
		List<CopingStrategy> copings = copingService.findAllByUserId((Integer) session.getAttribute("userId"));

		model.addAttribute("copings", copings != null ? copings : Collections.emptyList());
		model.addAttribute("userName", (String) session.getAttribute("userName"));

		return "coping/list";
	}

	/**コーピング編集画面*/
	@PostMapping("/edit")
	public String detail(@ModelAttribute CopingForm form, Model model, HttpSession session,
			@RequestParam("copingId") Integer copingId, RedirectAttributes attributes) {
		// セッションからユーザーIDを取得、なければ認証から取得
		userSessionService.ensureUserSession(session);
		Integer userId = (Integer) session.getAttribute("userId");
		CopingStrategy copingStrategy = copingService.findByCopingIdAndUserId(copingId, userId);
		if (copingStrategy != null) {
			form.setCoping_id(copingId);
			form.setUser_id(userId);
			form.setCreated_at(copingStrategy.getCreated_at());
			model.addAttribute("theCoping", copingStrategy);

			return "coping/edit";
		} else {
			attributes.addFlashAttribute("message", "無効なリクエストが送信されました");
			return "redirect:/coping";
		}
	}

	/**コーピング更新*/
	@PostMapping("/update")
	public String update(@Valid CopingForm form, BindingResult bindingResult, RedirectAttributes attributes,
			Model model, HttpSession session) {

		if (userSessionService.isAuthorizedUser(session, form.getUser_id())) {
			//バリデーションチェック
			//入力チェックNG：入力画面を表示する
			if (bindingResult.hasErrors()) {
				model.addAttribute("theCoping", copingService.findByCopingIdAndUserId(
						form.getCoping_id(), form.getUser_id()));
				return "coping/edit";
			}
			CopingStrategy copingStrategy = CopingHelper.convertCopingStrategy(form);
			copingService.updateCopingStrategy(copingStrategy);
			attributes.addFlashAttribute("message", "コーピングを更新しました");
			return "redirect:/coping";
		} else {
			attributes.addFlashAttribute("message", "無効なリクエストが送信されました");
			return "redirect:/coping";
		}
	}

	/**コーピング新規登録画面*/
	@GetMapping("/form")
	public String newCoping(@ModelAttribute CopingForm form, HttpSession session) {
		// セッションからユーザーIDを取得、なければ認証から取得
		userSessionService.ensureUserSession(session);
		form.setUser_id((Integer) session.getAttribute("userId"));
		return "coping/new";
	}

	/**コーピング新規登録*/
	@PostMapping("/save")
	public String create(@Valid CopingForm form, BindingResult bindingResult, RedirectAttributes attributes,HttpSession session) {
		if(userSessionService.isAuthorizedUser(session, form.getUser_id())) {
		form.setExecution_count(0);
		//バリデーションチェック
		//入力チェックNG：入力画面を表示する
		if (bindingResult.hasErrors()) {
			return "coping/new";
		}
		CopingStrategy copingStrategy = CopingHelper.convertCopingStrategy(form);
		copingService.insertCopingStrategy(copingStrategy);
		attributes.addFlashAttribute("message", "新しいコーピングが追加されました");

		return "redirect:/coping";
		}else {
			attributes.addFlashAttribute("message", "無効なリクエストが送信されました");
			return "redirect:/coping";
		}

	}

	/**コーピング削除*/
	@PostMapping("/delete")
	public String delete(@RequestParam Integer copingId, HttpSession session, RedirectAttributes attributes) {
		userSessionService.ensureUserSession(session);
		Integer userId = (Integer)session.getAttribute("userId");
		CopingStrategy copingStrategy = copingService.findByCopingIdAndUserId(copingId, userId);
		if (copingStrategy != null) {
			copingService.deleteCopingStrategy(copingId);
			attributes.addFlashAttribute("message", "コーピングの削除が完了しました");
			return "redirect:/coping";
		}
		attributes.addFlashAttribute("message", "無効なリクエストが送信されました");
		return "redirect:/coping";
	}
}
