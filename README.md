# Sunflower Android app
## App configuration
- Gradle 8.3.2
- Java 17
- Kotlin 1.9.0
- Compose bom 2023.08.00
## App structure
![architecture-DATAFLOW drawio](https://github.com/f-lab-edu/sunflower-sksowk156/assets/110645858/a2a46739-f319-46a4-86b5-205dc9532f26)

```
| app
| feature
    | mygarden
    | planlist
| core
    | data : feature에 필요한 데이터를 여러 소스에서 가져옴
    | designsystem : 핵심 UI 구성 요소, 앱 테마 및 아이콘
    | model : 앱 전체에 쓰이는 data model
    | network : ktor를 활용한 http 데이터 통신
    | ui : features 모듈에서 사용되는 복합 UI 구성 요소 및 리소스
```
## Libraries
- Compose UI & navigation with an extended MVI pattern
- Orbit MVI Framework
- Menual DI
- Networking with Ktor
- Json converter with Moshi
- Loading image with Coil
- Streams with coroutines & flow
