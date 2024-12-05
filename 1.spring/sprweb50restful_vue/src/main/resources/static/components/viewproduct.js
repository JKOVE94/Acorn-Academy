
const ViewProduct = {
	template:`
		<div>
			<h2>제품 정보</h2>
			<table>
				<tr>
					<th>코드</th><th>제품명</th><th>설명</th><th>가격</th><th>사진</th><th>작업</th>
				</tr>
				<tr v-for="item in products" :key="item.code">
					<td>{{item.code}}</td>
					<td>{{item.comede}}</td>
					<td>{{item.description}}</td>
					<td>{{item.price}}</td>
					<td><img :src="item.image" alt="제품 이미지"></td>
					<td>
					<button @click="editProduct(item.code)">수정</button> /
					<button @click="deleteProduct(item.code)">삭제</button>
					</td>
				</tr>
			</table>
		</div>
	`,
	data(){
		return {products:[]}
	},
	methods:{
		fetchProdutcs(){
			axios.get("/products")
			.then(res => this.products = res.data)
			.catch(err => console.log("ViewProduct Err : " + err))
		}
	},
	created(){ //컴포넌트가 instance 된 직후 (렌더링 전)에 호출
		this.fetchProdutcs();
	}
}

export default ViewProduct;