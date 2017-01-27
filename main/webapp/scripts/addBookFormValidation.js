function addBookFormIsValid() {

    var bookName = document.getElementById("book_name").value;
    var author = document.getElementById("author").value;
    var genre = document.getElementById("genre").value;
    var annotation = document.getElementById("annotation").value;

    if(bookName.length == 0 || author.length == 0
        || genre.length == 0|| annotation.length == 0) {

        document.getElementById("msg").innerText = "each field must be filled";
        return false;
    }
    else {

        return true;
    }

}
