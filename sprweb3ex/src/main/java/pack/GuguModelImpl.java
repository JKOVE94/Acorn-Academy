package pack;

import org.springframework.stereotype.Service;

@Service
public class GuguModelImpl implements GuguModelInter{
	@Override
	public String calcGugu(int num) {
		String gugu="";
		for(int i=1; i<=9; i++) {
			gugu+=num+"X"+i+"="+(num*i)+"<br/>";
		}
		return gugu;
	}

}
