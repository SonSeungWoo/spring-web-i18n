### spring messageSource

#### Header
언어를 Accept-language header로 받을경우 AcceptHeaderLocaleResolver 에서
request header정보 가져와 Locale에 설정해준다.

요청 executive summary
localhost:8080/message
Headers
Accept-language : en_us


#### Param
LocaleChangeInterceptor bean등록후 WebMvcConfigurer의 addInterceptors에 추가해준다.

요청 executive summary
주석처리된 부분을 주석제거하고 실행
localhost:8080/message?locale=en_us

#### properties 설정
언어만으로 locale설정시 message_en.properties
언어및국가 locale설정시 message_en_US.properties

