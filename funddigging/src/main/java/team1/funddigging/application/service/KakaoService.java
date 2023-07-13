package team1.funddigging.application.service;

import ...

@Service
@Getter
@Setter
public class KakaoService {
    // test
    public String[] getAccessToken(String code) throws IOException { // access token을 인가 코드를 카카오에 넘겨 다시 받아오는 역할을 수행
        String reqURL = "https://kauth.kakao.com/oauth/token";
        String access_token = "";
        String refresh_token = "";
        URL url = new URL(reqURL);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        String returnValue[] = new String[2];

        try {
            urlConnection.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=66e775d4c6e22638c91bb9e4fb5e7e97");
            sb.append("&redirect_uri=http://localhost:8080/user/add/kakao/permission");
            sb.append("&code=" + code);

            bw.write(sb.toString());
            bw.flush();

            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("result = " + result);

            // json parsing
            JsonParser parser = new JsonParser();
            JsonElement elem = parser.parse(result);

            access_token = elem.getAsJsonObject().get("access_token").getAsString();
            refresh_token = elem.getAsJsonObject().get("refresh_token").getAsString();
            System.out.println("refresh_token = " + refresh_token);
            System.out.println("access_token = " + access_token);

            String token = access_token;

            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        returnValue[0] = access_token;
        returnValue[1] = refresh_token;

        return returnValue;
    }

    public HashMap<String, Object> getUserInfo(String accessToken) {
        HashMap<String, Object> userInfo = new HashMap<>();

        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
            Long userId = element.getAsJsonObject().get("id").getAsLong();


            String email = kakaoAccount.getAsJsonObject().get("email").getAsString();
            String name = kakaoAccount.getAsJsonObject().get("profile").getAsJsonObject().get("nickname").getAsString();
//            String phoneNumber = kakaoAccount.getAsJsonObject().get("phone_number").getAsString();
//            String birthDay = kakaoAccount.getAsJsonObject().get("birthday").getAsString();
//
//
            userInfo.put("nickname", name);
            userInfo.put("email", email);
//            userInfo.put("phoneNumber", phoneNumber);
//            userInfo.put("birthDay", birthDay);
            userInfo.put("userKakaoId", userId);
//
//            System.out.println("user name: " + name);
//            System.out.println("user email: " + email);
//            System.out.println("user phone: " + phoneNumber);
//            System.out.println("user ID: " + userId);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo;
    }

}