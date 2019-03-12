package tw.com.liwei.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;

import tw.com.liwei.register.model.MemberBean;
import tw.com.liwei.register.service.MemberService;

@Controller
public class LoginController {
	
	private static String client_id = "22042621167-ikc0vnt83k0rd0bs4rq4ljn2578lk124.apps.googleusercontent.com";

	@Autowired
	MemberService ms;
	
	@RequestMapping(value="/totalLogin",method=RequestMethod.GET)
	public String totalLogin() {
//		MemberBean mb = new MemberBean();
//		model.addAttribute("memberService",mb);
		return "totalLogin";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
//		MemberBean mb = new MemberBean();
//		model.addAttribute("memberService",mb);
		return "login";
	}
	
	@RequestMapping(value="/login/googleVerify",method=RequestMethod.POST)
	@ResponseBody
	public String loginSuccess(String idTokenStr,Model model) {
		model.addAttribute("loginMethod","google");
		System.out.println(idTokenStr);
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
				new NetHttpTransport(), JacksonFactory.getDefaultInstance())
				.setAudience(Collections.singletonList(client_id)).build();
		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(idTokenStr);
		} catch (GeneralSecurityException e) {
			System.out.println("驗證時出現GeneralSecurityException異常");
		} catch (IOException e) {
			System.out.println("驗證時出現IOException異常");
		}
		if (idToken != null) {
			System.out.println("驗證成功.");
			Payload payload = idToken.getPayload();
			String userId = payload.getSubject();
			System.out.println("User ID: " + userId);
			String email = payload.getEmail();
			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");
			String pictureUrl = (String) payload.get("picture");
			String locale = (String) payload.get("locale");
			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");
			System.out.println(email+name+familyName);
		} else {
			System.out.println("Invalid ID token.");
		}
		return "loginSuccess";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/userInfo")
	@ResponseBody
	public String getUserInfo(@RequestParam("userInfo") String userInfo,Model model) {
		model.addAttribute("loginMethod","facebook");
		System.out.println("sssss");
		Map<String,String> map = new Gson().fromJson(userInfo,Map.class); 
		System.out.println(userInfo);
		System.out.println(map.get("name"));
		return "loginSuccess";
	}
}
