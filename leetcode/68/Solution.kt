import java.util.ArrayList

class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val answer = ArrayList<String>()
        var currentLength = 0

        val temp = ArrayList<String>()
        for (word in words) {
            // 현재 길이 + 단어의 개수(=공백)
            val length = currentLength + temp.size

            if (length + word.length <= maxWidth) {
                // 다음 단어를 추가해도 maxWidth를 넘지 않는다면
                temp.add(word)
                currentLength += word.length
            } else {
                // 다음 단어를 추가하면 maxWidth를 넘는다면

                // 1. 현재 단어들을 가운데 정렬
                answer.add(justify(temp, currentLength, maxWidth))

                // 2. 초기화 및 다음 단어 추가
                temp.clear()
                currentLength = word.length
                temp.add(word)
            }
        }

        if (temp.isNotEmpty()) answer.add(leftJustify(temp, maxWidth))
        return answer
    }

    private fun leftJustify(temp: ArrayList<String>,  maxWidth: Int): String {
        // 문장
        val sb = StringBuilder()

        return with(sb) {
            for (i in temp.indices) {
                val str = temp[i]

                sb.append(str)
                // 띄어쓰기 추가
                if (sb.length < maxWidth) {
                    sb.append(" ")
                }
            }

            // 남은 공간을 채워준다.
            while (sb.length < maxWidth)
                sb.append(" ")


            toString()
        }

    }

    private fun justify(temp: ArrayList<String>, currentLength: Int, maxWidth: Int): String {
        // 빈칸의 개수 = maxWidth - (단어들의 길이)
        val spaces = (maxWidth - currentLength)

        // 각 글자 사이에 들어가는 빈칸
        //  1. 단어가 1개인 경우 => 빈칸을 모두 채워준다.
        //  2. 단어가 2개 이상인 경우 => 빈칸을 (단어의 개수 - 1)로 나눈 값
        val unit = if (temp.size == 1) spaces else spaces / (temp.size - 1)

        // 빈칸이 남는 경우 ex) 14 / 3 = 4 ... 2
        //  1. 단어가 1개인 경우 => 0
        //  2. 단어가 2개 이상인 경우 => 남은 빈칸을 (단어의 개수 - 1)로 나눈 나머지
        var extra = if (temp.size == 1) 0 else spaces % (temp.size - 1)

        // 문장
        val sb = StringBuilder()
        return with(sb) {
            for (i in temp.indices) {
                val str = temp[i]

                // 단어 추가
                sb.append(str)
                if (sb.length < maxWidth) {
                    // 단어 사이에 빈칸 추가
                    sb.append(" ".repeat(unit))

                    // 빈칸이 있는 경우, 1칸씩 채운다
                    // 왼쪽부터 1개씩 늘려주면 된다.
                    if (extra-- > 0) {
                        sb.append(" ")
                    }
                }
            }

            toString()
        }
    }
}
