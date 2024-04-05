<div align="center">
<h1>Notification-Service</h1>
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
멘토링 서비스에서 멘토링 신청, 멘토링 신청 수락, 멘토링 신청 거절 이벤트가 발생하면 Kafka 메시지 브로커를 통해 알림 서비스(Notification-Service)로 메시지가 전달된다. 

Kafka 메시지 브로커를 사용한 이유는 2가지이다. 

1) 신청, 수락, 거절 이벤트가 발생한 순서를 보장할 수 있어야 한다. 
2) 단순한 서비스 간 통신으로 이벤트를 알림 서비스로 전달하는 경우, 알림 서비스가 다운되면 이벤트는 발생했지만 알림은 사라져 버리는 문제가 발생한다. 알림 서비스에 이상이 생겨도 이벤트가 어딘가에 저장되어, 알림서비스가 나중에 복구되었을때 다시 읽어들일 수 있는 구조가 필요하였다. Kafka는 파티션에서 읽지 않았던 지점을 offset으로 관리하므로, 알림 서비스가 다운되었다가 복구되어도 다시 읽을 수 있다. 


### - 나의 알림 조회
DB에 저장되어 있는 멘토링 신청, 수락, 거절 알림을 조회한다.


<br>
<br>
