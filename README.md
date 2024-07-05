# Проект "Симуляция"

Суть проекта - пошаговая симуляция 2D мира, населённого травоядными и хищниками. Кроме существ, мир содержит ресурсы (траву), которыми питаются травоядные, и статичные объекты, с которыми нельзя взаимодействовать - они просто занимают место.

2D мир представляет из себя матрицу NxM, каждое существо или объект занимают клетку целиком, нахождение в клетке нескольких объектов/существ - недопустимо.

Идея взята [отсюда](https://www.youtube.com/watch?v=SfEZSyvbj2w) и упрощена.

Комментарии по проекту - [https://www.youtube.com/watch?v=3Vrwx4iryhw](https://www.youtube.com/watch?v=3Vrwx4iryhw).

## Что нужно знать

- [Java]({{ site.baseurl }}/Technologies/Java/) - коллекции, ООП

## Мотивация проекта

Основная цель - демонстрация принципов дизайна архитектуры приложения с помощью ООП. Описанная ниже структура классов не является всеобъемлющей, предполагается что студент будет ей следовать, взяв за основу.

## Дизайн классов

### `objects.Entity`

Корневой абстрактный класс для всех существ и объектов существующих в симуляции.

### `Grass`, `Rock`, `Tree`

`Rock`, `Tree` - статичные объекты. `Grass` - ресурс для травоядных.

### `objects.Creature`

Абстрактный класс, наследуется от `objects.Entity`. Существо, имеет скорость (сколько клеток может пройти за 1 ход), количество HP. Имеет абстрактный метод `makeMove()` - сделать ход. Наследники будут реализовывать этот метод каждый по-своему.

### `Herbivore`

Травоядное, наследуется от `objects.Creature`. Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.

### `Predator`

Хищник, наследуется от `objects.Creature`. В дополнение к полям класса `objects.Creature`, имеет силу атаки. На что может потратить ход хищник:
- Переместиться (чтобы приблизиться к жертве - травоядному)
- Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника. Если значение HP жертвы опускается до 0, травоядное исчезает

### `Map`

Карта, содержит в себе коллекцию для хранения существ и их расположения. Советую не спешить использовать двумерный массив или список списков, а подумать какие ещё коллекции могут подойти.

### `Simulation`

Главный класс приложения, включает в себя:
- Карту
- Счётчик ходов
- Рендерер поля
- Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу (детали ниже)

Методы:
- `nextTurn()` - просимулировать и отрендерить один ход
- `startSimulation()` - запустить бесконечный цикл симуляции и рендеринга
- `pauseSimulation()` - приостановить бесконечный цикл симуляции и рендеринга

### `Actions`

`Action` - действие, совершаемое над миром. Например - сходить всеми существами. Это действие итерировало бы существ и вызывало каждому `makeMove()`. Каждое действие описывается отдельным классом и совершает операции над картой. Симуляция содержит 2 массива действий:
- `initActions` - действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте
- `turnActions` - действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало

### Поиск пути

Советую писать алгоритм поиска пути полностью с нуля, используя в качестве источника описание алгоритма на википедии. Проще всего начать с алгоритма [поиска в ширину](https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D0%B8%D1%81%D0%BA_%D0%B2_%D1%88%D0%B8%D1%80%D0%B8%D0%BD%D1%83). Он относительно простой в реализации, но может работать медленно на больших полях, для которых лучше подойдет алгоритм [A\*](https://ru.wikipedia.org/wiki/A*).

### Рендерер

Рендерер ответственен за визуализацию состояния поля, его отрисовку. По желанию студента интерфейс приложения может быть консольным, либо графическим).

## Конечная цель

Реализовать симуляцию и подобрать различные значения так, чтобы взаимодействия внутри мира получились максимально интересными:
- Размер поля
- Диапазоны HP и скорости существ
- Диапазон атаки хищников

Опциональные идеи для усложнения проекта:
- Механика размножения существ
- Механика голода, когда от отсутствия пищи у них начинает уменьшаться HP

## Ресурсы для работы над ошибками

- Эталонная [реализация проекта](https://github.com/zhukovsd/chess) похожего уровня сложности, написанного на серии [стримов](https://www.youtube.com/watch?v=Pzydm8GZzMs)
- Реализации проекта другими студентами и мои ревью этих реализаций - [https://zhukovsd.github.io/java-backend-learning-course/Projects/FinishedProjects](https://zhukovsd.github.io/java-backend-learning-course/Projects/FinishedProjects)
- Чеклист для самопроверки с типовыми ошибками (в конце страницы)
- Готовый проект можете отправить мне на ревью - [https://t.me/zhukovsd](https://t.me/zhukovsd)
  - **[Обновление от 7 сентября 2023]** - целевое количество видео и текстовых ревью проекта "Симуляция" накоплено, новые реализации к ревью не принимаются. В любом случае призываю отправлять законченные проекты в [чат](https://t.me/zhukovsd_it_chat), добавляю их в [список](https://zhukovsd.github.io/java-backend-learning-course/Projects/FinishedProjects/). Подробности - [https://t.me/zhukovsd_it_mentor/57](https://t.me/zhukovsd_it_mentor/57) 

## Чеклист для самопроверки

❗️**Спойлеры**: советую не читать этот список до того момента, пока не допишете первую самостоятельную работающую версию проекта❗️

Проблемы и ошибки в коде:
- Интеграция библиотеки графического интерфейса ценой чистоты и понятности кода. Достаточно консольного интерфейса
- Дублирование кода между классами Herbivore и Predator
- Класс Map
  - Неоптимальный выбор коллекции для хранения состояния ячеек
  - Не использование generics, параллельные коллекции для разных типов существ (для каждого типа своя коллекция)
  - Заполнение карты "пустотами"
  - Недостаточная энкапсуляция - "протекающее" наружу внутреннее устройство класса Map (например, прямой доступ к коллекции ячеек) вместо набора методов с говорящими названиями (`AddEntity`, `RemoveEntity`, и так далее)
  - [Пример чистой энкапсуляции](https://gist.github.com/zhukovsd/7813f34044f69dc160681db88e654b71#map)
- Иерархия классов `Action`'s
  - Дублирование кода
  - [Пример чистой реализации](https://github.com/immagixe/Matrix2077/tree/master/src/main/java/main/java/Matrix2077/actions)
- Неоднозначное именование полей, переменных, методов. Несовпадение имён смысловой нагрузке
- Поиск пути
  - Реализация алгоритма поиска пути внутри классов существ. Следует вынести это в отдельный класс
  - Дублирование кода для поиска пути хищниками и травоядными

Мелочи:
- Неиспользование `.gitignore`, из-за чего в репозиторий попадают лишние файлы и папки (например, `target`, `out`)
- Неаккуратное форматирование кода
- Неиспользование пакетов для структурирования классов, все классы в корне проекта
