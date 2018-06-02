package webstore.intercepters;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PromoCodeInterceptors extends HandlerInterceptorAdapter {
	private String promoCode;
	private String errorRedirect;
	private String offerRedirect;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String givenPromoCode = request.getParameter("promo");
		if (promoCode.equals(givenPromoCode)) {
			response.sendRedirect(request.getContextPath() + "/" + offerRedirect);
		} else {
			response.sendRedirect(errorRedirect);
		}
		return false;
	}
	
	public String getPromoCode() {
		return promoCode;
	}
	
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	public String getErrorRedirect() {
		return errorRedirect;
	}
	
	public void setErrorRedirect(String errorRedirect) {
		this.errorRedirect = errorRedirect;
	}
	
	public String getOfferRedirect() {
		return offerRedirect;
	}
	
	public void setOfferRedirect(String offerRedirect) {
		this.offerRedirect = offerRedirect;
	}
}
