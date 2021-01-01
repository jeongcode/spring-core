package hello.core.lifeCycle;

// javax는 자바에서 공식적으로 지원하는 것들
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 , url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("Connect : " + url);
    }

    public void call(String message){
        System.out.println("Call : " + url + " message : "+ message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    // 의존관계 주입이 끝나면 호출
    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    // 서버가 종료 될 때
    @PreDestroy
    public void close() throws Exception {
        System.out.println("destory");
        disconnect();
    }
}
