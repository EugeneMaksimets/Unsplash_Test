# Unsplash_Test

Приложение обращается к API unsplash и получает 30 рандомных фото по ключу unsplash ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9
url запроса: 
https://api.unsplash.com/photos/random?count=30&client_id=ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9

Для получение json по API и парсинга его в java объект используется билиотека gson и okhttp вся логика описана в .../service/UnsplahsApiService

Для отображения списка с превью фото, описанием и автором был создан макет list.xml а в main.xml использовался RecyclerView. Где в свою очередь .../service/ListRecyclerViewAdapter и .../service/ListRecyclerViewHolder устанавливали макет, а так же при инициализации адаптера устанавливается Listener для отслеживания нажатия из списка и вызова OpenImageActivity с нужной ссылкой

OpenImageActivity получает сохраненную ссылку с full качеством и открывает фото, так же активити смотрит ширину дисплея устройства и устанавливает ширину при отображении фото
