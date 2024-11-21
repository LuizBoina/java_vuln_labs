CMD = ./mvnw spring-boot:run -s ./settings.xml -nsu -DskipTests

.PHONY: auth-bypass1 csrf file-upload idor lfi2 parameter-binding rfi url-redirection xss-stored xxe

auth-bypass1 csrf file-upload idor lfi2 parameter-binding rfi url-redirection xss-stored xxe:
	@cd $@ && $(CMD)
