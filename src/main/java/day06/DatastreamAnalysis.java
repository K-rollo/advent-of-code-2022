package day06;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class DatastreamAnalysis {

    String bufferInputStringData = "dcbcsbblhhgdgssmcmqccdwdvwdvvcfvcfvvpvmmwccdqddshhdppcfpfbbfggfjfvvhzhmmsqswsttcgtctggjllhnnqbnnnldlglplvlbvbzztpzzvpphshwwfhhgssvgsvvpfvfzznbznndqqtsqttnvtvqqqrgqrrgzzlqzzbvzbzmzffnbfnbffcggdcggqhqpqzpqzqbbqvbqbhhtzhhrrrprlrclrcrssqspqpbblggfvvbpvbbssvttsztzpzjjwffnpnfnrrqhqgqrrzqzbzzdpdjpplpclpptltztjtztqthtmmmpsmmpjpqpvvshhsfshhrvrdvdggwssdbbzbttlmlmpprmrmlrrmqrqsshjhjljzjnjllbbvjvnnppqbppqqfffrbfbdfbbqppmtppfttqddtzzwbblqqbddgwgqwqzwwpzwzjjbccdjdwwrggrmrtmrtmrrvpptwwcdcwwsdshhjjhwjwqjwwqsshrrbsblssphspsjpssnsmsqswqwfwjwccdvccrqqnsqnsnwsnsmnmccvcqqfjjfljfljfjgjffjvffvjvhjhfhrfrlrrtpphbhwbbvmmnpndnlljdjfjsffvccnhchwhddrccljllmnnhmnmpnnhtnthnhvnhnwnqqjmmgzzvssphhjljbjwjbwwdnwwdvvzpvvhccvjjlclrrppgjgsshghvvzjvvpvvbjjqhjqqfcqffchcmmvdvtddftdtppfnppcnpnznwwpdpjpnpttlbbmmqfqmffqnfnbffbrbgbwggsmsbbfgbbfbzbtzbbvmmdlmlrlnlwwbswsjjpjhhwqwzqznqzqvvwccwvwwcbbpvvwcvcvzzhzchzccbnccjlljsjbjdbbvqbvvfdfgdfggzfzlzmzrznnqsnncmnnljjtcjcfftrthtrhrgrvvjggzpggrcrpcppggdfggpmmwnmnlmlglvvmjvvddsmsjsnjssqffffctczcjzjjlbbhpbbfdbdzbbsjbjnjbbqqjbqjbjjhwhssmvsschhhwppbjppllprpjrppdpfpgpjptjtptplpnptnptpjjmcmnnnhnjhjlhjlhjlhlwwhwmwjjbhhlfffrbbgvvqwvwswtstmmmfpmfpffmcfcrrqsqzqjjjnpnnztnznddlwdldsdbssstzstswwjtttmmwmsmwssvswszsjzsjjsffmccmfccqzzvpmbbbsqffgzdqbjtzhlqdzhlpwghlstcrcrffrnbwjnqgmbmpgttfmsswdqctlrpdnlsgnlldvbfpwtcptvbwftzcnbbscrrcpnwtmllcvsrmwzzlsdmfctdcwsqdlsnzgfpmzrnswhbqjhstztzzmzpcttsgsggnlhvjmcbbrhgqhsfmglpcbdvmmmnfbtbfrqbpcmttjtnwvznbshwrmznnsvpjqjntlzspljnbwtjcqztsfcqlrggrpzjgjsvqqcrmrjmzwdsshqfhbtfmlwmfvtbcgdmjgtcnphfmfmjlbjzrvjslccftnwcchgdwjnlthlwgldjwqwgdptdjdmzdrrzcdpbfrtdgcspjtqdqvzswwdwrhggdrqjjgwwrbwhhlrpqmszvlvjfqptncjlscvzbgzgmsttlbhbfrctnsphjcrcwlhcgrcrsjbrjvptgfbjgjrvtzmnhpzcgptbmrgvstsltnctjphsjdwpdqblfswzfhgjbpfrptlmhfwcpdlzqccgtdvbzhwngrhlqftmlhjprscflgzpflvvpfsjmlnmbzsrlrshvnsqrhhlqdlzhrcbjjjfrbqcdspwsmltcrtlbdnbnvhbbwgqdcncsztbfwztzdbqgcrnvndmpstpncbwvtctzdpmcpvrgqvjjztfwpvjtdqlvcvdpfzgcghsmbcwtzztmqwdpsprgsmfhphqsqmflrjdqzjscgzlnvcwcrlmpdscnhqpqjfdbdftqgttwntdbpnshdwnmwsrslfgnzlnwwwqgdbfnthhqtvbzsqgzjhhghtmvvfhlmlpbghnsvlttzsjlgndhdqmqqfdlqnbfscsnnqzcdwzdlqcnstcbsffghftqvwrsshgwmlnprhdnnwslwfwtmtfzdjwpmlvvdhjvdwrhvdsmpgrdpnqsjpqmhttrmdwllrmnbznwjwvvpjnnbnfzbdnhjbqqrnzgdqbspbqtwdpgsbwpzfdbpvzfjpsgmztnzrpvvhwlfscfvfpfblvplgdbhvjjpdjtnwrmvpjsphvglpsntvwtqwqvprcgwjltddpjngvmzfzhmqnnwglbzsbrcztpplpsmgmcfgzgpbtgsjrfvdzzcsthznvdpbwvdlcgdhncsjdvpcbbmtrqczctjljdfghsrvrsfjglqqhjttfdhqdqwhzhqrggsjwlldrntwmmbftgqjhpvvctpbtgltnttlhdqbsbwcqmctwlsnhmhncpmnzsllmjhcgnlfgvpcqrwzvsstgwbvjtnrlbblclzdrcwddrwnptqzgwdwtgrfwffpzjmwbqfmmrcfzfzjbwsslbhggtwtcrlhffzgfgrtljgnznnlgzwfmtwwqzhlthvpfclrtmrqfzrggbctzfsmjhrtwzpfrnhwwprnbwmvwvmvnzqpggmzgslctqbqdtvhgzjwzsnblqzmcpnpwllzhvzzmfqzfjlrsrcnjzqdzbpjftljtzvvmrjszvqllnhhgnrnqttnwlvllphjtnmlwqhcvmbsvnwtcdmhsmhdcwqwtvggcqfpdsrsscmhcvfzvdnffrfhdfmgbsghdbpwdwrdmlvsnzwcfchcqvccszdqrbnfvrpbftcwnjmczwgqzmtlmrthlhtjpmchltcmcqwgfgshtvtpmcmpbmlnjmhnpdsljjmjzddnlgtnjqztzsqqlhtqcscjvjncjvfcvsgjhqgzrmtjjcgvvmwswffmlcvlhqhbvrldrvbrfmmqcnqmfzlsghvclrdbsvcbqspgbzmjnlrdhvncnbcfmdlqrssggsmlwwglcjjzmcdwcnrgvvmgjcfbzlncmgqtllgldbdztbtfcjczqtjjlnpqmrgtjsmrbscvqlgqghfbgwccgwrjrzrsbbrqnjcqhllsqmrjtzmjnndwwmdjfhspjpgdcjjpdvwrsgjcfnpllnnnccvnfvqbpddgvbgbsbczmbzrbclczljdmbhpgmhwlqvnjzjwzzfjmsmcchjrqrtmhwlgjsptctlbtdnrqgntcvngcrqdqptfmhbvlhrqchdtwdwbrbqwtswzcrrfndldwmjbczppzrnncvvqsmpvvqcnsvhprhlmrhnjbwdvrbbwwdtmzrqttschrztgjcshlhfbmhmwrrmwgmfshpdhjwgdmcfdvqrmmwgmzbrlgbfltvlzmvqbgvhppdzglqbdlrhjnntnfvtmzjqccmqdbpjqphfggmjqdrndhclcfvqsjrsbcgdhcrbjsdjmwrzvpfpcjwjfdltztfzgmlzqzmztpvbflppgnhdzssznngfjggczdtdmcczjzfsnflpwqrbggmqdbbprfptzcdqvhrvszzjqqjlrlrdpwcnzhvgfhpcdbbgsfmtnszwbhwcdwdghqqctwqlqrlqbdwfvjnhcpmzchqfrwzhzgslzhncmrlrpzcjczvzwcvwcldbmscfqnnqnwwvrpfvjswqmhgmhgnmfzpsjmdhbpvsftccttvdpcdzcnzswqmtrwbctpbgmzrvrrshjjgdqsqrwfpcmsbvqhccvjqpztlttwjjdtbmwslschpqjjllvjcjwtmrtvvwdzglstvtpndmmzcpgqsvqgfdtqdjdctsbsbmqzqhtczhgqgwbdlrhjrwcmtbzfndsbnpnhmsdhtghwwzvtdwtscdnwzmrjrsrjvvbvrpbszchwbltrjbcqmlhqnzcfbhjqnsjghlnlbsrgzrrzfvslwpbqmgfswhgjdsdfrzsdhvdqvqfbcbvmbfhjfpzwlbspcbnvrgpfnmjbwbsnpqpqhjpsnwrlcmfhpdmjbvpnctcfqgdmwzblsnr";
    Queue<Character> bufferInputStream = new ArrayDeque<>();
    Set<Character> setOfCharacters = new HashSet<>();
    int indexOfFirstMarker = 0;

    public int getFirstMarkerIndex() {
        for (int i = 0; i < 4; i++) {
            bufferInputStream.offer(bufferInputStringData.charAt(i));
        }

        bufferInputStream.poll();

        for (int i = 4; i < bufferInputStringData.length(); i++) {
            bufferInputStream.poll();
            bufferInputStream.offer(bufferInputStringData.charAt(i));
            setOfCharacters.clear();
            for (int j = 0; j < 4; j++) {
                setOfCharacters.add(bufferInputStringData.charAt(i - j));
            }
            if (setOfCharacters.size() > 3) {
                indexOfFirstMarker = i + 1;
                break;
            }

        }
        return indexOfFirstMarker;
    }

    public int getFirstMarkerIndexForMessage() {
        for (int i = 0; i < 14; i++) {
            bufferInputStream.offer(bufferInputStringData.charAt(i));
        }

        bufferInputStream.poll();

        for (int i = 14; i < bufferInputStringData.length(); i++) {
            bufferInputStream.poll();
            bufferInputStream.offer(bufferInputStringData.charAt(i));
            setOfCharacters.clear();
            for (int j = 0; j < 14; j++) {
                setOfCharacters.add(bufferInputStringData.charAt(i - j));
            }
            if (setOfCharacters.size() > 13) {
                indexOfFirstMarker = i + 1;
                break;
            }

        }
        return indexOfFirstMarker;
    }

//    public void getFirstMarkerIndex() {
//        for (Character ch : bufferInputStream) {
//            System.out.println(ch);
//        }
//    }
}
