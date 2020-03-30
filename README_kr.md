# scouter-plugin-server-alert-line-notify
[![Englsh](https://img.shields.io/badge/language-English-orange.svg)](README.md) ![Korean](https://img.shields.io/badge/language-Korean-blue.svg)

### Scouter server plugin to send a alert via line

- 본 프로젝트는 스카우터 서버 플러그인으로써 서버에서 발생한 Alert 메시지를 Line으로 전송하는 역할을 한다.
- 현재 지원되는 Alert의 종류는 다음과 같다.

	- Agent의 CPU (warning / fatal)
	- Agent의 Memory (warning / fatal)
	- Agent의 Disk (warning / fatal)
	- 신규 Agent 연결
	- Agent의 연결 해제
	- Agent의 재접속
    - 특정서비스 응답시간의 임계치 초과(Java agent에서 설정)

### Properties (스카우터 서버 설치 경로 하위의 conf/scouter.conf)
* **_ext\_plugin\_line\_send\_alert_** : Line 메시지 발송 여부 (true / false) - 기본 값은 false
* **_ext\_plugin\_line\_debug_** : 로깅 여부 - 기본 값은 false
* **_ext\_plugin\_line\_level_** : 수신 레벨(0 : INFO, 1 : WARN, 2 : ERROR, 3 : FATAL) - 기본 값은 0
* **_ext\_plugin\_line\_notify\_token_** : Line notify bot Token
 
* Example
```
# External Interface (Line)
ext_plugin_line_send_alert=true
ext_plugin_line_debug=false
ext_plugin_line_level=0
ext_plugin_line_access_token=XXXXXXXXXXXXXXXXXXXXXXXXXXXX
ext_plugin_line_group_id=XXXXXXXXXXXXXXXXXXXXXXXXXXXX
```

### Dependencies
* Project
    - scouter.common
    - scouter.server
* Library
    - commons-codec-1.9.jar
    - commons-logging-1.2.jar
    - gson-2.6.2.jar
    - httpclient-4.5.2.jar
    - httpcore-4.4.4.jar
    
### Build & Deploy
* mvn clean package
    
* Deploy
    - dependency library와 함께 scouter-plugin-server-alert-line-notify-xxx.jar 파일을 복사하여 Scouter Server 설치 경로 하위의 lib/ 폴더에 Copy 한다.
    
