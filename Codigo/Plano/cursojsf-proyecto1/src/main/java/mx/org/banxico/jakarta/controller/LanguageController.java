package mx.org.banxico.jakarta.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@SessionScoped
public class LanguageController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6683490036946541465L;
	private Locale locale;
	private Map<String, String> supportedLanguages;
	
	@PostConstruct
	public void init() {
		//locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
//		HttpServletRequest request  = (HttpServletRequest) FacesContext
//					.getCurrentInstance()
//					.getExternalContext().getRequest();
		this.locale  = FacesContext
				.getCurrentInstance()
				.getExternalContext().getRequestLocale();
		
					
		FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
		supportedLanguages = new HashMap<String, String>();
		supportedLanguages.put("Ingles", "en");
		supportedLanguages.put("Español", "es");
	}
	
	public String selectLanguage(ValueChangeEvent event) {
		
		String newLaguage = event.getNewValue().toString();
		
		supportedLanguages.values().forEach(valor -> {
			if (valor.equals(newLaguage)) {
				this.locale = new Locale(newLaguage);
				FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
			}
		});
		return FacesContext.getCurrentInstance().getViewRoot().getViewId() + 
				"?faces-redirect=true";
	}
}







