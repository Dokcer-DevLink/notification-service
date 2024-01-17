<div align="center">
<h1>Mentoring-Service</h1>
<h3> 멘토링 신청, 수락, 거절 알림를 담당하는 서비스 

알림 서비스</h3>
</div>

<br>
<br>


## Architecture
<img width="9116" alt="아키텍처" src="https://github.com/Dokcer-DevLink/mentoring-service/assets/80077569/b4d1f6a3-e31c-4ca2-9800-ededc7d267d0">

<br>
<br>

## Description

### - Kafka 연동
멘토링 신청, 멘토링 신청 수락, 멘토링 신청 거절 요청이 멘토링 서비스에 들어오면, Kafka 메시지 브로커를 통해 알림 서비스(Notification-Service)로 메시지가 전달된다. 메시지는 신청, 수락, 거절 로 구분되어 DB에 저장된다.

### - 나의 알림 조회
DB에 저장되어 있는 멘토링 신청, 수락, 거절 알림을 조회한다.
