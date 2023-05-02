# Unsplash_Test

Приложение обращается к API unsplash и получает 30 рандомных фото по ключу unsplash ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9

url запроса: 
https://api.unsplash.com/photos/random?count=30&client_id=ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9

Для получение json по API и парсинга его в java объект используется билиотека gson и okhttp вся логика описана в .../service/UnsplahsApiService

Для отображения списка с превью фото, описанием и автором был создан макет list.xml а в main.xml использовался RecyclerView. Где в свою очередь .../service/ListRecyclerViewAdapter и .../service/ListRecyclerViewHolder устанавливали макет, а так же при инициализации адаптера устанавливается Listener для отслеживания нажатия из списка и вызова OpenImageActivity с нужной ссылкой

OpenImageActivity получает сохраненную ссылку с full качеством и открывает фото, так же активити смотрит ширину дисплея устройства и устанавливает ширину при отображении фото

<img width="188" alt="Снимок экрана 2023-05-02 в 17 23 24" src="https://user-images.githubusercontent.com/76277201/235695827-cc1aceac-5105-48a6-b475-1e6539d01aa9.png">
<img width="182" alt="Снимок экрана 2023-05-02 в 17 24 09" src="https://user-images.githubusercontent.com/76277201/235695858-7cb4dac5-5851-4bda-aa98-99b333ce8b9e.png">
<img width="196" alt="Снимок экрана 2023-05-02 в 17 23 57" src="https://user-images.githubusercontent.com/76277201/235695864-6f1815ba-636e-4e40-9d9a-6cf957ca996d.png">
