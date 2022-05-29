package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailTemplateDTO {
	private String sendTo;
	private String subject;
	private String body;

}
