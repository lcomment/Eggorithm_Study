class programers_신규아이디추천 {
    public String solution(String new_id) {
        String cleanedId = new_id.toLowerCase();

        // 2단계: 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 이외의 모든 문자 제거
        cleanedId = cleanedId.replaceAll("[^a-z0-9-_.]", "");

        // 3단계: 마침표(.)가 2번 이상 연속된 경우 하나의 마침표로 치환
        cleanedId = cleanedId.replaceAll("\\.{2,}", ".");

        // 4단계: 첫 번째와 마지막이 마침표(.)인 경우 제거
        cleanedId = cleanedId.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열인 경우 "a"를 대입
        if (cleanedId.isEmpty()) {
            cleanedId = "a";
        }

        // 6단계: 길이가 16자 이상인 경우 첫 15개 문자만 남기고 나머지 제거
        if (cleanedId.length() >= 16) {
            cleanedId = cleanedId.substring(0, 15);
            cleanedId = cleanedId.replaceAll("\\.$", "");
        }

        // 7단계: 길이가 2자 이하인 경우 마지막 문자를 길이가 3이 될 때까지 반복
        while (cleanedId.length() <= 2) {
            cleanedId += cleanedId.charAt(cleanedId.length() - 1);
        }

        return cleanedId;
    }
}