## 1. Các trường tiêu đề gồm:

.cú pháp

```
# title (tương ứng với h1)
## title (tương ứng với h2)
### title (tương ứng với h3)
#### title (tương ứng với h4)
##### title (tương ứng với h5)
###### title (tương ứng với h6)
```
.hiển thị

+ # title (tương ứng với h1)
+ ## title (tương ứng với h2)
+ ### title (tương ứng với h3)
+ #### title (tương ứng với h4)
+ ##### title (tương ứng với h5)
+ ###### title (tương ứng với h6)

## 2. In nghiêng, in đậm các từ/câu: 

.cú pháp
```
*word* hoặc _word_ (in nghiêng)
**word** hoặc __word__ (in đậm)
**_word_** (vừa in nghiên vừa in đậm)
~~word~~ (từ bị gạch)
```

.hiển thị
+ *word* hoặc _word_ (in nghiêng)
+ **word** hoặc __word__ (in đậm)
+ **_word_** (vừa in nghiên vừa in đậm)
+ ~~word~~ (từ bị gạch)

## 3. Link

.cú pháp
```
[this is a link](https://www.google.com) (link dạng in-line)
[this is a link](https://www.google.com "Google's Homepage") (link dạng in-line, khi hover vào có thông báo Google's Homepage)
[this is a link](../blob/master/hanekawa.jpg) (link trỏ tới thư mục khác trong cùng repository trên git)
```

.hiển thị
+ [this is a link](https://www.google.com) (link dạng in-line)
+ [this is a link](https://www.google.com "Google's Homepage") (link dạng in-line, khi hover vào có thông báo Google's Homepage)
+ [this is a link](../blob/master/hanekawa.jpg) (link trỏ tới thư mục khác trong cùng repository trên git)

## 4. Image

.cú pháp
```
![alt_text](link_img "title_img") 
trong đó :
alt_text là tên hiển thị khi ảnh lỗi hoặc không load được, link_img là đường dẫn trực tiếp tới ảnh, title_img là nội dung khi hover vào ảnh

![đây là ảnh 1](https://github.com/shounen-chiemi/baitaplon/blob/master/ez-home.jpg "Ảnh 1") 
```

.hiển thị
![đây là ảnh 1](https://github.com/shounen-chiemi/baitaplon/blob/master/ez-home.jpg "Ảnh 1") 

## 5. Highlighting

highlight từ hoặc câu

.cú pháp
```
từ hoặc câu highlight đặt trong 1 dấu `
`highlight`
```

.hiển thị
+ `highlight` 

highlight đoạn code

.cú pháp
<span>
  ```javascript <br/>
  var s = "JavaScript syntax highlighting"; <br/>
  alert(s); <br/>
  ``` 
</span>

.hiển thị
```javascript
var s = "JavaScript syntax highlighting";
alert(s);
``` 

## 6. Table
(có thể sử dụng cả in đậm, in nghiêng hay highlight trong bảng)

.cú pháp
```
| *Cột 1* | Cột 2 | Cột 3 |
| --- | --- | --- |
| _dữ liệu ok_ | thời tiết đẹp | $1600 |
| dữ liệu rất ok | `thời tiết xấu` | $12 |
| dữ liệu thật ok | thời tiết khô ráo | $1 |
```

.hiển thị
| *Cột 1* | Cột 2 | Cột 3 |
| --- | --- | --- |
| _dữ liệu ok_ | thời tiết đẹp | $1600 |
| dữ liệu rất ok | `thời tiết xấu` | $12 |
| dữ liệu thật ok | thời tiết khô ráo | $1 |

## 7. Blockquotes

.cú pháp
```
> Blockquotes are very handy in email to emulate reply text. 
```

.hiển thị
> Blockquotes are very handy in email to emulate reply text.

## 8. Emoji: (tham khảo các emoji tại https://www.webfx.com/tools/emoji-cheat-sheet/)

.cú pháp
`:bowtie: :smile:` 

.hiển thị
:bowtie: :smile:

