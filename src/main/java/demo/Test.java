package demo;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by CHENXINXIN on 2016/8/20.
 */
public class Test {
    public static void main(String[] args) {

    }

    /**
     * 是否为素数
     */
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int k = (int) Math.sqrt(n);
        for (int i = 2; i <= k; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 多线程Future
     */
    public void future(){
        Set<String> set = Sets.newHashSet("web","download","vod","live");
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<Map> cs = new ExecutorCompletionService<>(executor);
        for(final String yyType : set) {
            cs.submit(new Callable<Map>() {
                public Map call() throws Exception {
                    return ImmutableMap.of(yyType, "hello, "+yyType);
                }
            });
        }
        for(int i = 0; i < set.size(); i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

