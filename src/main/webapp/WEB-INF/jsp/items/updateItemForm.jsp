<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>

<div class="container">
    <form role="form" method="post">
        <!-- id -->
        <input type="hidden" name="id" value="${item.id}">

        <div class="form-group">
            <label for="name">상품명</label>
            <input type="text" name="name" class="form-control" id="name" placeholder="이름을 입력하세요" value="${item.name}">
        </div>
        <div class="form-group">
            <label for="price">가격</label>
            <input type="number" name="price" class="form-control" id="price" placeholder="가격을 입력하세요" value="${item.price}">
        </div>
        <div class="form-group">
            <label for="stockQuantity">수량</label>
            <input type="number" name="stockQuantity" class="form-control" id="stockQuantity" placeholder="수량을 입력하세요" value="${item.stockQuantity}">
        </div>
        <div class="form-group">
            <label for="author">저자</label>
            <input type="text" name="author" class="form-control" id="author" placeholder="저자를 입력하세요" value="${item.author}">
        </div>
        <div class="form-group">
            <label for="isbn">ISBN</label>
            <input type="text" name="isbn" class="form-control" id="isbn" placeholder="ISBN을 입력하세요" value="${item.isbn}">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    <br/>
</div> <!-- /container -->
</body>
</html>
