# 마인크래프트 조합법(Recipe) 제작을 위한 플러그인

플러그인을 실행하고, plugins/Rep/config.yml 파일에서 조합법을 설정할 수 있습니다.

조합법은 shaped와 shapeless로 나누어 설정할 수 있습니다. 말 그대로 정해진 모양이 있느냐 없느냐의 차이입니다.

### shaped 조합법 설정 가이드

모양이 있는 조합법은 config.yml의 shaped: 밑에 내용을 추가하면 됩니다.

예시 코드가 있는데, 삭제해도 좋습니다. 이 예시 코드도 조합법을 추가합니다.

```yaml
shaped:
  saddle:
```
위와 같이 추가하고 싶은 조합법의 간단한 설명을 써 주십시오. 조합 결과 아이템의 이름을 적어도 좋습니다.

이는 조합법의 네임스페이스 키가 됩니다.

두 단어 이상을 연결하려면 _로 구분해 연결하는 것을 추천합니다.

이제 우리가 지정해야 할 것은 아이템을 조합하기 위한 모양, 모양의 각 칸에 놓아야 할 아이템, 완성될 아이템입니다.

모양부터 지정해 줍시다.

모양은 아무 문자를 사용하여 최대 3*3으로 지정할 수 있습니다.



한 줄이 한 행이라고 보시면 됩니다.

그리고 다른 아이템을 놓아야 할 칸은 다른 문자를 사용하여 지정해 주십시오.

빈 칸이 필요하다면 공백으로 두면 됩니다.

예를 들어 다이아몬드 곡괭이의 조합법은 아래와 같습니다.

```yaml
shape:
  - "DDD"
  - " S "
  - " S "
```

D는 다이아몬드, S는 막대기입니다.

```yaml
shape:
  - "D"
  - "S"
  - "S"
```

다이아몬드 삽처럼 꼭 세 줄이 아니여도 됩니다.

저도 안장의 조합법을 추가하기 위해 아래와 같이 해 보겠습니다.

```yaml
shaped:
  saddle:
    shape:
      - "LLL"
      - "LLL"
      - "LDL"
```

이제 각 칸에 놓을 아이템을 지정할 시간입니다.

모양을 지정할 때 사용한 문자와 마인크래프트에 존재하는 아이템의 타입을 대응시키면 됩니다.

이때는 Material이라는 아이템 이름을 열거해 둔 형식으로 기입해야 합니다.

https://jd.papermc.io/paper/1.20/org/bukkit/Material.html

여기서 Material의 리스트를 볼 수 있습니다. 어떤 아이템인지 대충 이해가 가실 겁니다.

저는 위의 조합 모양에서 L을 가죽으로, D를 다이아몬드로 설정하기 위해 아래와 같이 해 보겠습니다.

```yaml
shaped:
  saddle:
    shape:
      - "LLL"
      - "LLL"
      - "LDL"
    ingredient:
      L: LEATHER
      D: DIAMOND
```

이제 마지막으로 결과 아이템만 설정하면 됩니다.

결과 아이템의 종류(Material로 기입), 개수는 필수적으로 적어야 합니다.

또한 선택적으로 아이템의 이름을 설정할 수 있습니다.


```yaml
shaped:
  saddle:
    shape:
      - "LLL"
      - "LLL"
      - "LDL"
    ingredient:
      L: LEATHER
      D: DIAMOND
    result:
      type: SADDLE
      amount: 1
      name: MAKEREKAM의 안장
```

type은 아이템의 종류, amount는 아이템의 개수, name은 아이템의 이름을 뜻합니다.


자, 이제 모양이 있는 아이템 추가는 끝났습니다. 수고하셨습니다.

시스템이 자동으로 여러분의 서버에 조합법을 추가할 것입니다.


### shapeless 조합법 설정 가이드

이제 모양이 없는 조합법을 만들어 봅시다.

모양이 없다는 것은 재료를 아무렇게나 놓아도 조합이 된다는 뜻입니다.

따라서 모양을 설정할 필요도 없고, 모양에 맞는 재료를 설정할 필요도 없습니다.

재료 리스트와 결과 아이템만 있으면 됩니다.

shapeless 조합법은 config.yml에 이렇게 작성하면 됩니다.

```yaml
shapeless:
  soul_sand:
```

soul_sand 대신 여러분이 추가할 이름으로 바꾸시면 됩니다.

재료를 추가해 보겠습니다.

```yaml
shapeless:
  soul_sand:
    ingredient:
      - SAND
      - COAL
```

여기서도 재료를 추가할 때는 Material을 사용합니다.

결과값을 추가하는 것은 위에서 다뤘으므로 넘어가겠습니다.

```yaml
shapeless:
  soul_sand:
    ingredient:
      - SAND
      - COAL
    result:
      type: SOUL_SAND
      amount: 1
      name: MAKEREKAM의 영혼 모래
```

조합대의 아무 곳에 모래와 석탄을 올리면 영혼 모래를 얻을 수 있는 조합법이 완성되었습니다.

이제 shaped 조합법과 shapeless 조합법을 모두 사용해 보겠습니다.

```yaml
shapeless:
  soul_sand:
    ingredient:
      - SAND
      - COAL
    result:
      type: SOUL_SAND
      amount: 1
  soul_sand2:
    ingredient:
      - SAND
      - IRON_INGOT
    result:
      type: SOUL_SAND
      amount: 2

shaped:
  saddle:
    shape:
      - "LLL"
      - "LLL"
      - "LDL"
    ingredient:
      L: LEATHER
      D: DIAMOND
    result:
      type: SADDLE
      amount: 1
      name: MAKEREKAM의 안장
  diamond:
    shape:
      - "GG"
      - "GG"
    ingredient:
      G: GOLD_INGOT
    result:
      type: DIAMOND
      amount: 2
      name: MAKEREKAM의 다이아몬드
```
