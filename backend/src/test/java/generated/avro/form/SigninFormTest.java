package generated.avro.form;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

@Slf4j
class SigninFormTest {

    @Test
    void testBuild() throws Exception {
        val form = SigninForm.newBuilder()
                .setUsername("peerapat a")
                .setPassword("P@ssw0rd")
                .build();

        log.info("Message size {}", form.toByteBuffer().array().length);

        val bean = SigninForm.fromByteBuffer(form.toByteBuffer());
        log.info("B {}", bean);

        assert bean != form : "instance should be different";
        assert bean.equals(form) : "instance should equivalent";
    }

}