package com.ziletech.ecommerce.service;

import dto.EmailTemplateDTO;


public interface EmailService {

	void sendTextEmail(EmailTemplateDTO emailTemplate);

}
