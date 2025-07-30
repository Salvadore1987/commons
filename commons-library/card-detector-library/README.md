# Card Processing Detector

Библиотека для определения типа процессинговой системы банковских карт по BIN (первые 6 цифр номера карты).

## Поддерживаемые типы карт

- VISA
- MasterCard  
- UnionPay
- Humo
- UzCard
- American Express
- Diners Club
- Discover
- ChinaPay
- МИР

## Использование

```java
BinDetect detector = new BinDetector();
ProcessingType type = detector.detect("4111111111111111"); // VISA
```

## Подключение зависимости

### Maven

```xml
<dependency>
    <groupId>uz.salvadore</groupId>
    <artifactId>card-detector-library</artifactId>
    <version>${project.version}</version>
</dependency>
```

### Gradle

```gradle
implementation 'uz.salvadore:card-processing-detector:1.0.0'
```

## Требования

- Java 21+