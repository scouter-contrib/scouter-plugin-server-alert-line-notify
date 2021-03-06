# scouter-plugin-server-alert-line-notify
![Englsh](https://img.shields.io/badge/language-English-orange.svg) [![Korean](https://img.shields.io/badge/language-Korean-blue.svg)](README_kr.md)

### Scouter server plugin to send a alert via line-notify

- This plug-in sends alert messages generated from the server to the line messenger specific group or chat room.
- Currently supported types of Alert are as follows
    - All alert occurred from agents.
	  - on exceeding CPU threshold of Host agent(warning / fatal)
	  - on exceeding Memory threshold of Host agent (warning / fatal)
	  - on exceeding Disk usage threshold of Host agent (warning / fatal)
	  - agent's connection
	  - agent's disconnection
	  - agent's reconnection
      - on exceeding service response time
      - ...

### Properties (conf/scouter.conf)
* **_ext\_plugin\_line\_send\_alert_** : use alert to a line messenger feature or not (true / false) - default false
* **_ext\_plugin\_line\_debug_** : debug logging option - default false
* **_ext\_plugin\_line\_level_** : alert level to send (0 : INFO, 1 : WARN, 2 : ERROR, 3 : FATAL) - default 0
* **_ext\_plugin\_line\_notify\_token_** : Line notify bot token (![https://notify-bot.line.me/en/](https://notify-bot.line.me/en/))

* Example
```
# External Interface (Line)
ext_plugin_line_send_alert=true
ext_plugin_line_debug=false
ext_plugin_line_level=0
ext_plugin_line_notify_token=XXXXXXXXXXXXXXXXXXXXXXXXXXXX
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
    - copy scouter-plugin-server-alert-line-notify-xxx.jar and all dependent libraries(exclude scouter.server and scouter.commong) to lib directory of scouter server home.
    
