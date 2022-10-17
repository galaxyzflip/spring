package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller //컨트롤러 구현
public class HelloController {

	@RequestMapping("/hello.do") //클라이언트의 요청을 처리할 메서드를 지정하는 어노테이션, /hello.do 로 요청이 들어오면 아래 메소드를 실행한다.
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", getGreeting());
		return mav;
	}
	
	private String getGreeting() {
		int hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY);
		if(hour >= 6 && hour <= 10) {
			return "좋은 아침입니다.";
			
		}else if(hour >= 12 && hour <= 15) {
			return "점심 식사는 하셨나요?";
			
		}else if(hour >= 18 && hour <= 22) {
			return "좋은 밤 되세요";
		}
		return "안녕하세요?";
		
	}
	
}
