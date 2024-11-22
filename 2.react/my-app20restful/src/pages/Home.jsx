import { Link } from 'react-router-dom';

const Home = () => {
    return(
        <>
            <h1>메인 (Home)</h1>
            <h2>정보 확인용 페이지</h2>
            <ul>
                <li><Link to="/members">전체 회원 목록</Link></li>
            </ul>
        </>
    );
}
export default Home;