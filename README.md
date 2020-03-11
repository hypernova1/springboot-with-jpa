# 실전! 스프링 부트와 JPA 활용 2

## API 데이터를 운반할땐 `Entity`가 아닌 `Dto`를 사용
### `Entity` 와 *API 스펙*의 분리 (Side Effect 방지)
* API 요청시 해당 스펙을 정확히 알 수 있음
* `Entity` 를 요청을 받을 때 사용하게 되면 API 각각의 스펙을 정확하게 알기 힘듬
* 각 API마다 유효성 검증을 다르게 할 수 있음 