import Book from './book.js'

class Magazine extends Book{
	constructor(title, author, isbn, issueNumber){
		super(title, author, isbn);
		this.issueNumber = issueNumber;  // 잡지 호수
	}
	

	toString(){
		return `책 제목:${this.title}, 저자:${this.author}, ISBN:${this.isbn} ***:${this.issueNumber}`;
	}
}
export default Magazine;
