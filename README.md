
# 📊 대용량 데이터 처리 템플릿

## 📝 개요

이 프로젝트는 **Redis**, **Kafka**, **Spring Boot**를 사용한 실시간 대용량 데이터 처리 템플릿입니다. 
<br>
JManager를 통해 값을 전송, 해당 값을 Redis에 저장하고, Kafka를 사용하여 효율적으로 통신하게끔 구성했습니다. 
<br>
Redis는 빠른 데이터 접근 속도를 제공하여 실시간 데이터를 저장하고 검색하는 데 사용되고, Kafka는 데이터 스트림을 처리하고 여러 소비자에게 데이터를 신뢰성 있게 전달하는 데 사용됩니다.
<br>
백엔드에서 데이터를 가져와 보여주는 간단한 **React** 프론트엔드를 포함하고 있습니다.

## 🛠️ 사용 기술

| **Stack**                  | **Description**                                                                 |
|----------------------------|---------------------------------------------------------------------------------|
| **Backend**                | ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%236DB33F.svg?&style=for-the-badge&logo=spring-boot&logoColor=white) ![Redis](https://img.shields.io/badge/Redis-%23DC382D.svg?&style=for-the-badge&logo=redis&logoColor=white) ![Kafka](https://img.shields.io/badge/Apache%20Kafka-%231A8C81.svg?&style=for-the-badge&logo=apache-kafka&logoColor=white) |
| **Frontend**               | ![React](https://img.shields.io/badge/React-%2320232a.svg?&style=for-the-badge&logo=react&logoColor=%2361DAFB)         |
| **Test**                   | ![Apache JMeter](https://img.shields.io/badge/Apache%20JMeter-%23361a1a.svg?&style=for-the-badge&logo=apache-jmeter&logoColor=%231E62C8)       |
| **Development Environment**| ![Docker](https://img.shields.io/badge/Docker-%230db7ed.svg?&style=for-the-badge&logo=docker&logoColor=white) ![Docker Compose](https://img.shields.io/badge/Docker%20Compose-%2336465D.svg?&style=for-the-badge&logo=docker&logoColor=white) ![JDK](https://img.shields.io/badge/JDK-17%2B-%23B07219.svg?&style=for-the-badge&logo=java&logoColor=white) ![Node.js](https://img.shields.io/badge/Node.js-%23339933.svg?&style=for-the-badge&logo=nodedotjs&logoColor=white) ![Apache JMeter](https://img.shields.io/badge/Apache%20JMeter-%23361a1a.svg?&style=for-the-badge&logo=apache-jmeter&logoColor=%231E62C8)    |

## 🚀 시작하기

### 📋 필요 조건

- Docker
- Docker Compose
- JDK 17+
- Node.js 및 npm (React 프론트엔드용)
- Apache JMeter (부하 테스트용)

### 🔧 프로젝트 설정

1. **리포지토리 클론:**

    ```sh
    git clone <https://github.com/sonhoil/Largevolume.git>
    cd realTimeInsight
    ```

2. **백엔드 빌드 및 실행 (Docker 사용):**

    ```sh
    docker-compose up --build
    ```

3. **프론트엔드 디렉토리로 이동 후 의존성 설치:**

    ```sh
    cd frontend
    npm install
    ```

4. **React 애플리케이션 실행:**

    ```sh
    npm start
    ```

### ⚙️ 설정

- **백엔드:**

  `application.properties` 파일에서 Redis 및 Kafka 설정을 구성합니다.

  ```properties
  spring.redis.host=redis
  spring.redis.port=6379

  spring.kafka.bootstrap-servers=kafka:9092
  spring.kafka.consumer.group-id=group_id
  spring.kafka.topic.name=webSocketTopic
  ```

## 🧪 부하 테스트

**Apache JMeter**를 사용하여 부하 테스트를 수행합니다:

1. JMeter를 열고 테스트 계획을 생성합니다.
2. 스레드 그룹과 HTTP 요청 샘플러를 추가합니다.
3. HTTP 요청 샘플러를 `http://localhost:8080/api/addData` 또는 `http://localhost:8080/api/data`로 설정합니다.
4. 테스트 계획을 실행하여 부하를 시뮬레이션하고 성능을 측정합니다.

## 📈 프로젝트 성과

| **기능**                       | **설명**                                                                 |
|-----------------------------|----------------------------------------------------------------------|
| **실시간 데이터 처리**          | Redis와 Kafka를 사용하여 실시간으로 대용량 데이터를 처리하는 시스템 구축                                      |
| **확장 가능 아키텍처**          | Docker를 활용하여 애플리케이션을 컨테이너화하여 확장성과 이식성을 향상                                       |
| **부하 테스트 자동화**          | Apache JMeter를 사용하여 부하 테스트를 자동화하고 시스템의 성능을 검증                                        |
| **프론트엔드 통합**             | React를 사용하여 백엔드 데이터와 상호작용할 수 있는 프론트엔드 구축                                           |

## 📊 JMeter 부하 테스트 결과

- **테스트 시나리오:** 1000명의 동시 사용자가 `/api/addData` 엔드포인트에 데이터를 추가
- **결과:** 
  - 평균 응답 시간: 200ms
  - 최대 응답 시간: 500ms
  - 오류율: 0.1%
- **해석:** 시스템은 대량의 동시 요청을 효율적으로 처리할 수 있으며, Redis와 Kafka를 통해 실시간 데이터를 안정적으로 처리함을 확인하였습니다.
