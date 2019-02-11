package com.qrms.spring.config;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
		
		private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		
		
		@Override
		public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response, Authentication authentication)
				throws IOException, ServletException {
			handle(request, response, authentication);
	        clearAuthenticationAttributes(request);
	        
//			Collection<?extends GrantedAuthority> authorities = authentication.getAuthorities(); //<?extends means any sub-type of GrantedAuthority is also allowed in the collection
//			
//			authorities.forEach(authority -> {
//				if(authority.getAuthority().equals("ROLE_USER")) {
//					try {
//						redirectStrategy.sendRedirect(arg0, arg1, "/u/student-home");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				} else if(authority.getAuthority().equals("ROLE_ADMIN")) {
//					try {
//						redirectStrategy.sendRedirect(arg0, arg1, "/u/admin-home");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				} else if(authority.getAuthority().equals("ROLE_FACULTY")) {
//					try {
//						redirectStrategy.sendRedirect(arg0, arg1, "/u/faculty-home");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else {
//		            throw new IllegalStateException();
//		        }
//			});
			
		}
		
		protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
			  
			        String targetUrl = determineTargetUrl(authentication);
			        redirectStrategy.sendRedirect(request, response, targetUrl);
	    
		}
			 
	    protected String determineTargetUrl(Authentication authentication) {
			        boolean isFaculty = false;
			        boolean isAdmin = false;
			        boolean isStudent = false;
			        
			        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			        for (GrantedAuthority grantedAuthority : authorities) {
			            if (grantedAuthority.getAuthority().equals("ROLE_STUDENT")) {
			                isStudent = true;
			                break;
			            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
			                isAdmin = true;
			                System.out.println("Admin login");
			                break;
			            } else if (grantedAuthority.getAuthority().equals("ROLE_FACULTY")) {
			                isFaculty = true;
			                break;
			            }
			        }
			 
			        if (isStudent) {
			            return "/u/student/home";
			        } else if (isFaculty) {
			            return "/u/faculty/home";
			        } else if (isAdmin) {
			        	return "/u/admin/home";
			        }
			        else {
			            throw new IllegalStateException();
			        }
			    }
			 
	    protected void clearAuthenticationAttributes(HttpServletRequest request) {
			        HttpSession session = request.getSession(false);
			        if (session == null) {
			            return;
			        }
			        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			    }
			 
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
			        this.redirectStrategy = redirectStrategy;
			    }
	    
	    protected RedirectStrategy getRedirectStrategy() {
			        return redirectStrategy;
			    }
}


