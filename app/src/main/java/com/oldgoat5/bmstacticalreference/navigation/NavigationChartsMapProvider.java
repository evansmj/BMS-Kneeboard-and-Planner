package com.oldgoat5.bmstacticalreference.navigation;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;
import java.util.HashMap;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 12/25/2015
 *********************************************************************/
public class NavigationChartsMapProvider
{
    private ArrayList<String> japanKoreaAirbaseList;
    private ArrayList<String> northKoreaAirbaseList;
    private ArrayList<String> southKoreaAirbaseList;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> japanKoreaHashMap;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> northKoreaHashMap;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> southKoreaHashMap;

    public ArrayList<String> getJapanKoreaAirbaseList()
    {
        return this.japanKoreaAirbaseList;
    }

    public ArrayList<String> getNorthKoreaAirbaseList()
    {
        return this.northKoreaAirbaseList;
    }

    public ArrayList<String> getSouthKoreaAirbaseList()
    {
        return this.southKoreaAirbaseList;
    }

    public HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> getJapanKoreaHashMap()
    {
        return this.japanKoreaHashMap;
    }

    public HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> getNorthKoreaHashMap()
    {
        return this.northKoreaHashMap;
    }

    public HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> getSouthKoreaHashMap()
    {
        return this.southKoreaHashMap;
    }

    public void setJapanKorea()
    {
        ArrayList<NavigationChartsTuple<String, Integer>> fukuoka = new ArrayList<>();

        ArrayList<String> groups = new ArrayList<>();
        HashMap<
           String, ArrayList<NavigationChartsTuple<String, Integer>>> children = new HashMap<>();

        groups.add("Fukuoka (Kadena) Airbase");
        fukuoka.add(new NavigationChartsTuple<String, Integer>(
                "Fukuoka (Kadena) Airport Diagram", R.drawable.fukuoka_kadena_airport_diagram));
        fukuoka.add(new NavigationChartsTuple<String, Integer>(
                "Fukuoka (Kadena) Departure", R.drawable.fukuoka_kadena_departure));
        fukuoka.add(new NavigationChartsTuple<String, Integer>(
                "Fukuoka (Kadena) ADIZ Crossing", R.drawable.fukuoka_kadena_adiz_crossing));
        fukuoka.add(new NavigationChartsTuple<String, Integer>(
                "Fukuoka (Kadena) ILS RWY 01", R.drawable.fukuoka_kadena_ils_rwy_01));
        fukuoka.add(new NavigationChartsTuple<String, Integer>(
                "Fukuoka (Kadena) ILS RWY 19", R.drawable.fukuoka_kadena_ils_rwy_19));
        fukuoka.add(new NavigationChartsTuple<String, Integer>(
                "Fukuoka (Kadena) TACAN RWY 15", R.drawable.fukuoka_kadena_tacan_rwy_15));
        fukuoka.add(new NavigationChartsTuple<String, Integer>(
                "Fukuoka (Kadena) TACAN RWY 33", R.drawable.fukuoka_kadena_tacan_rwy_33));

        children.put(groups.get(0), fukuoka);

        japanKoreaAirbaseList = groups;
        japanKoreaHashMap = children;
    }

    public void setNorthKorea()
    {
        ArrayList<NavigationChartsTuple<String, Integer>> airstrips = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> haeju = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> hwangju = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> hwangsuwon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> hyonni = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> iwon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kaechon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> koksan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kuumni = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kwail = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> manpo = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> mirim = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> onchon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> ongjin = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> orang = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> panghyon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> pukchangup = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> samjiyonup = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> sondok = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> sunan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> sunchon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> taechon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> taetan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> toksan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> uiju = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> wonsan = new ArrayList<>();

        ArrayList<String> groupsList = new ArrayList<>();
        HashMap<
           String, ArrayList<NavigationChartsTuple<String, Integer>>> childrenMap = new HashMap<>();

        groupsList.add("Airstrips");
        airstrips.add(new NavigationChartsTuple<String, Integer>(
                "East-West Airstrips", R.drawable.north_korea_airstrips_east_west));
        airstrips.add(new NavigationChartsTuple<String, Integer>(
                "North-South Airstrips", R.drawable.north_korea_airstrips_north_south));
        childrenMap.put(groupsList.get(0), airstrips);

        groupsList.add("Haeju Airbase");
        haeju.add(new NavigationChartsTuple<String, Integer>(
                "Haeju Airport Diagram", R.drawable.haeju_airport_diagram));
        childrenMap.put(groupsList.get(1), haeju);

        groupsList.add("Hwangju Airbase");
        hwangju.add(new NavigationChartsTuple<String, Integer>(
                "Hwangju Airport Diagram", R.drawable.hwangju_airport_diagram));
        childrenMap.put(groupsList.get(2), hwangju);

        groupsList.add("Hwangsuwon Airbase");
        hwangsuwon.add(new NavigationChartsTuple<String, Integer>(
                "Hwangsuwon Airport Diagram", R.drawable.hwangsuwon_airport_diagram));
        childrenMap.put(groupsList.get(3), hwangsuwon);

        groupsList.add("Hyon-Ni Airbase");
        hyonni.add(new NavigationChartsTuple<String, Integer>(
                "Hyon-Ni Airport Diagram", R.drawable.hyonni_airport_diagram));
        childrenMap.put(groupsList.get(4), hyonni);

        groupsList.add("Iwon Airbase");
        iwon.add(new NavigationChartsTuple<String, Integer>(
                "Iwon Airport Diagram", R.drawable.iwon_airport_diagram));
        childrenMap.put(groupsList.get(5), iwon);

        groupsList.add("Kaech`on Airbase");
        kaechon.add(new NavigationChartsTuple<String, Integer>(
                "Kaech`on Airport Diagram", R.drawable.kaechon_airport_diagram));
        childrenMap.put(groupsList.get(6), kaechon);

        groupsList.add("Koksan Airbase");
        koksan.add(new NavigationChartsTuple<String, Integer>(
                "Koksan Airport Diagram", R.drawable.koksan_airport_diagram));
        childrenMap.put(groupsList.get(7), koksan);

        groupsList.add("Kuum-ni Airbase");
        kuumni.add(new NavigationChartsTuple<String, Integer>(
                "Kuum-ni Airport Diagram", R.drawable.kuumni_airport_diagram));
        childrenMap.put(groupsList.get(8), kuumni);

        groupsList.add("Kwail Airbase");
        kwail.add(new NavigationChartsTuple<String, Integer>(
                "Kwail Airport Diagram", R.drawable.kwail_airport_diagram));
        childrenMap.put(groupsList.get(9), kwail);

        groupsList.add("Manp`o Airbase");
        manpo.add(new NavigationChartsTuple<String, Integer>(
                "Manp`o Airport Diagram", R.drawable.manpo_airport_diagram));
        childrenMap.put(groupsList.get(10), manpo);

        groupsList.add("Mirim Airbase");
        mirim.add(new NavigationChartsTuple<String, Integer>(
                "Mirim Airport Diagram", R.drawable.mirim_airport_diagram));
        childrenMap.put(groupsList.get(11), mirim);

        groupsList.add("Onch`on Airbase");
        onchon.add(new NavigationChartsTuple<String, Integer>(
                "Onch`on Airport Diagram", R.drawable.onchon_airport_diagram));
        childrenMap.put(groupsList.get(12), onchon);

        groupsList.add("Ongjin Airbase");
        ongjin.add(new NavigationChartsTuple<String, Integer>(
                "Ongjin Airport Diagram", R.drawable.ongjin_airport_diagram));
        childrenMap.put(groupsList.get(13), ongjin);

        groupsList.add("Orang Airbase");
        orang.add(new NavigationChartsTuple<String, Integer>(
                "Orang Airport Diagram", R.drawable.orang_airport_diagram));
        childrenMap.put(groupsList.get(14), orang);

        groupsList.add("Panghyon Airbase");
        panghyon.add(new NavigationChartsTuple<String, Integer>(
                "Panghyon Airport Diagram", R.drawable.panghyon_airport_diagram));
        childrenMap.put(groupsList.get(15), panghyon);

        groupsList.add("Pukch`ang-up Airbase");
        pukchangup.add(new NavigationChartsTuple<String, Integer>(
                "Pukch`ang-up Airport Diagram", R.drawable.pukchangup_airport_diagram));
        childrenMap.put(groupsList.get(16), pukchangup);

        groupsList.add("Samjiyon-up Airbase");
        samjiyonup.add(new NavigationChartsTuple<String, Integer>(
                "Samjiyon-up Airport Diagram", R.drawable.samjiyonup_airport_diagram));
        childrenMap.put(groupsList.get(17), samjiyonup);

        groupsList.add("Sondok Airbase");
        sondok.add(new NavigationChartsTuple<String, Integer>(
                "Sondok Airport Diagram", R.drawable.sondok_airport_diagram));
        childrenMap.put(groupsList.get(18), sondok);

        groupsList.add("Sunan (Pyongyang) Airbase");
        sunan.add(new NavigationChartsTuple<String, Integer>(
                "Sunan (Pyongyang) Airport Diagram", R.drawable.sunan_pyongyang_airport_diagram));
        sunan.add(new NavigationChartsTuple<String, Integer>(
                "Sunan (Pyongyang) ILS RWY 18", R.drawable.sunan_pyongyang_ils_rwy_18));
        childrenMap.put(groupsList.get(19), sunan);

        groupsList.add("Sunch`on Airbase");
        sunchon.add(new NavigationChartsTuple<String, Integer>(
                "Sunch`on Airport Diagram", R.drawable.sunchon_airport_diagram));
        childrenMap.put(groupsList.get(20), sunchon);

        groupsList.add("T`aech`on Airbase");
        taechon.add(new NavigationChartsTuple<String, Integer>(
                "T`aech`on Airport Diagram", R.drawable.taechon_airport_diagram));
        childrenMap.put(groupsList.get(21), taechon);

        groupsList.add("Taetan Airbase");
        taetan.add(new NavigationChartsTuple<String, Integer>(
                "Taetan Airport Diagram", R.drawable.taetan_airport_diagram));
        childrenMap.put(groupsList.get(22), taetan);

        groupsList.add("Toksan Airbase");
        toksan.add(new NavigationChartsTuple<String, Integer>(
                "Toksan Airport Diagram", R.drawable.toksan_airport_diagram));
        childrenMap.put(groupsList.get(23), toksan);

        groupsList.add("Uiju Airbase");
        uiju.add(new NavigationChartsTuple<String, Integer>(
                "Uiju Airport Diagram", R.drawable.uiju_airport_diagram));
        childrenMap.put(groupsList.get(24), uiju);

        groupsList.add("Wonsan Airbase");
        wonsan.add(new NavigationChartsTuple<String, Integer>(
                "Wonsan Airport Diagram", R.drawable.wonsan_airport_diagram));
        childrenMap.put(groupsList.get(25), wonsan);

        this.northKoreaAirbaseList = groupsList;
        this.northKoreaHashMap = childrenMap;
    }

    public void setSouthKorea()
    {
        ArrayList<NavigationChartsTuple<String, Integer>> airstrips = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kotar = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> chongju = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> choongwon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> hoengsong = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kangnung = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kimhae = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kimpo = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kunsan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> kwangju = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> mandumi = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> osan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> pohang = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> pusan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> pyongtaek = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> sachon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> seosan = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> seoul = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> sokcho = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> suwon = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> taegu = new ArrayList<>();
        ArrayList<NavigationChartsTuple<String, Integer>> yechon = new ArrayList<>();

        ArrayList<String> groups = new ArrayList<>();
        HashMap<
            String, ArrayList<NavigationChartsTuple<String, Integer>>> children = new HashMap<>();

        groups.add("Airstrips");
        airstrips.add(new NavigationChartsTuple<String, Integer>(
                "East-West Airstrips", R.drawable.south_korea_airstrips_east_west));
        airstrips.add(new NavigationChartsTuple<String, Integer>(
                "North-South Airstrips", R.drawable.south_korea_airstrips_north_south));
        children.put(groups.get(0), airstrips);

        groups.add("Kotar");
        kotar.add(new NavigationChartsTuple<String, Integer>(
                "Kotar Range Diagram", R.drawable.kotar_range_diagram));
        kotar.add(new NavigationChartsTuple<String, Integer>(
                "Kotar Area Chart", R.drawable.kotar_area_chart));
        kotar.add(new NavigationChartsTuple<String, Integer>(
                "Kotar Target List", R.drawable.kotar_target_list));
        children.put(groups.get(1), kotar);

        groups.add("Chongju Airbase");
        chongju.add(new NavigationChartsTuple<String, Integer>(
                "Chongju Airport Diagram", R.drawable.chongju_airport_diagram));
        chongju.add(new NavigationChartsTuple<String, Integer>(
                "Chongju 5 Departure", R.drawable.chongju_five_departure));
        chongju.add(new NavigationChartsTuple<String, Integer>(
                "Chongju ILS RWY 23R", R.drawable.chongju_ils_rwy_23r));
        chongju.add(new NavigationChartsTuple<String, Integer>(
                "Chongju TACAN RWY 05L", R.drawable.chongju_tacan_rwy_05l));
        chongju.add(new NavigationChartsTuple<String, Integer>(
                "Chongju TACAN RWY 05R", R.drawable.chongju_tacan_rwy_05r));
        chongju.add(new NavigationChartsTuple<String, Integer>(
                "Chongju TACAN RWY 23L", R.drawable.chongju_tacan_rwy_23l));
        chongju.add(new NavigationChartsTuple<String, Integer>(
                "Chongju Visual Approach", R.drawable.chongju_visual_approach));
        children.put(groups.get(2), chongju);

        groups.add("Choongwon Airbase");
        choongwon.add(new NavigationChartsTuple<String, Integer>(
                "Choongwon Airport Diagram", R.drawable.choongwon_airport_diagram));
        choongwon.add(new NavigationChartsTuple<String, Integer>(
                "Choongwon One Departure", R.drawable.choongwon_1_departure));
        choongwon.add(new NavigationChartsTuple<String, Integer>(
                "Choongwon ILS RWY 34R", R.drawable.choongwon_ils_rwy_34r));
        choongwon.add(new NavigationChartsTuple<String, Integer>(
                "Choongwon TACAN 34L", R.drawable.choongwon_tacan_rwy_34l));
        choongwon.add(new NavigationChartsTuple<String, Integer>(
                "Choongwon TACAN RWY 16L", R.drawable.choongwon_tacan_rwy_16l));
        choongwon.add(new NavigationChartsTuple<String, Integer>(
                "Choongwon TACAN RWY 16R", R.drawable.choongwon_tacan_rwy_16r));
        children.put(groups.get(3), choongwon);

        groups.add("Hoengsong Airbase");
        hoengsong.add(new NavigationChartsTuple<String, Integer>(
                "Hoengsong Airport Diagram", R.drawable.hoengsong_airport_diagram));
        hoengsong.add(new NavigationChartsTuple<String, Integer>(
                "Hoengsong Wonju 3 Departure", R.drawable.hoengsong_wonju_four_departure));
        hoengsong.add(new NavigationChartsTuple<String, Integer>(
                "Hoengsong ILS RWY 02", R.drawable.hoengsong_ils_rwy_02));
        hoengsong.add(new NavigationChartsTuple<String, Integer>(
                "Hoengsong TACAN RWY 20", R.drawable.hoengsong_tacan_rwy_20));
        children.put(groups.get(4), hoengsong);

        groups.add("Kangnung Airbase");
        kangnung.add(new NavigationChartsTuple<String, Integer>(
                "Kangnung Airport Diagram", R.drawable.kangnung_airport_diagram));
        kangnung.add(new NavigationChartsTuple<String, Integer>(
                "Kangnung Gangwon 1 Departure", R.drawable.kangnung_gangwon_1_departure));
        kangnung.add(new NavigationChartsTuple<String, Integer>(
                "Kangnung ILS RWY 26", R.drawable.kangnung_ils_rwy_26));
        kangnung.add(new NavigationChartsTuple<String, Integer>(
                "Kangnung Circle to Land RWY 08", R.drawable.kangnung_circle_to_land_rwy_08));
        children.put(groups.get(5), kangnung);

        groups.add("Kimhae Airbase");
        kimhae.add(new NavigationChartsTuple<String, Integer>(
                "Kimhae Airport Diagram", R.drawable.kimhae_airport_diagram));
        kimhae.add(new NavigationChartsTuple<String, Integer>(
                "Kimhae Nakdong 3A Departure", R.drawable.kimhae_nakdong_3a_departure));
        kimhae.add(new NavigationChartsTuple<String, Integer>(
                "Kimhae Nakdong 4A Departure", R.drawable.kimhae_nakdong_4a_departure));
        kimhae.add(new NavigationChartsTuple<String, Integer>(
                "Kimhae ILS RWY 34", R.drawable.kimhae_ils_rwy_34));
        kimhae.add(new NavigationChartsTuple<String, Integer>(
                "Kimhae TACAN RWY 16", R.drawable.kimhae_tacan_rwy_16));
        children.put(groups.get(6), kimhae);

        groups.add("Kimpo Airbase");
        kimpo.add(new NavigationChartsTuple<String, Integer>(
                "Kimpo Airport Diagram", R.drawable.kimpo_airport_diagram));
        kimpo.add(new NavigationChartsTuple<String, Integer>(
                "Kimpo 1W&1E Departure", R.drawable.kimpo_1w_1e_departure));
        kimpo.add(new NavigationChartsTuple<String, Integer>(
                "Kimpo ILS RWY 14L", R.drawable.kimpo_ils_rwy_14l));
        kimpo.add(new NavigationChartsTuple<String, Integer>(
                "Kimpo ILS RWY 14R", R.drawable.kimpo_ils_rwy_14r));
        kimpo.add(new NavigationChartsTuple<String, Integer>(
                "Kimpo ILS RWY 32L", R.drawable.kimpo_ils_rwy_32l));
        kimpo.add(new NavigationChartsTuple<String, Integer>(
                "Kimpo ILS RWY 32R", R.drawable.kimpo_ils_rwy_32r));
        children.put(groups.get(7), kimpo);

        groups.add("Kunsan Airbase");
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan Airport Diagram", R.drawable.kunsan_airport_diagram));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan Parking", R.drawable.kunsan_spawn_points));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan Aladi One Departure", R.drawable.kunsan_aladi_1_departure));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan Coyote Three Departure", R.drawable.kunsan_coyote_3_departure));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan Patro Departure", R.drawable.kunsan_patro_departure));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan Alternate Runway", R.drawable.kunsan_alternate_runway));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan ILS RWY 18", R.drawable.kunsan_ils_rwy_18));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan ILS RWY 36", R.drawable.kunsan_ils_rwy_36));
        kunsan.add(new NavigationChartsTuple<String, Integer>(
                "Kunsan Visual Approach", R.drawable.kunsan_visual_18_36));
        children.put(groups.get(8), kunsan);

        groups.add("Kwangju Airbase");
        kwangju.add(new NavigationChartsTuple<String, Integer>(
                "Kwangju Airport Diagram", R.drawable.kwangju_airport_diagram));
        kwangju.add(new NavigationChartsTuple<String, Integer>(
                "Kwangju 3A Departure", R.drawable.kwangju_3a_departure));
        kwangju.add(new NavigationChartsTuple<String, Integer>(
                "Kwangju 4A Departure", R.drawable.kwangju_4a_departure));
        kwangju.add(new NavigationChartsTuple<String, Integer>(
                "Kwangju ILS RWY 02", R.drawable.kwangju_ils_rwy_02));
        kwangju.add(new NavigationChartsTuple<String, Integer>(
                "Kwangju ILS RWY 20", R.drawable.kwangju_ils_rwy_20));
        children.put(groups.get(9), kwangju);

        groups.add("Mandumi Airstrip");
        mandumi.add(new NavigationChartsTuple<String, Integer>(
                "Mandumi Airport Diagram", R.drawable.mandumi_airstrip_diagram));
        children.put(groups.get(10), mandumi);

        groups.add("Osan Airbase");
        osan.add(new NavigationChartsTuple<String, Integer>(
                "Osan Airport Diagram", R.drawable.osan_airport_diagram));
        osan.add(new NavigationChartsTuple<String, Integer>(
                "Osan Draggin 1 Departure", R.drawable.osan_draggin_1_departure));
        osan.add(new NavigationChartsTuple<String, Integer>(
                "Osan Jet Yoke 4 Departure", R.drawable.osan_jet_yoke_4_departure));
        osan.add(new NavigationChartsTuple<String, Integer>(
                "Osan ILS RWY 09", R.drawable.osan_ils_rwy_09));
        osan.add(new NavigationChartsTuple<String, Integer>(
                "Osan ILS RWY 27", R.drawable.osan_ils_rwy_27));
        children.put(groups.get(11), osan);

        groups.add("Pohang Airbase");
        pohang.add(new NavigationChartsTuple<String, Integer>(
                "Pohang Airport Diagram", R.drawable.pohang_airport_diagram));
        pohang.add(new NavigationChartsTuple<String, Integer>(
                "Pohang Posco 1 Departure", R.drawable.pohang_posco_1_departure));
        pohang.add(new NavigationChartsTuple<String, Integer>(
                "Pohang ILS RWY 26", R.drawable.pohang_ils_rwy_26));
        pohang.add(new NavigationChartsTuple<String, Integer>(
                "Pohang TACAN RWY 08", R.drawable.pohang_tacan_rwy_08));
        children.put(groups.get(12), pohang);

        groups.add("Pusan Airbase");
        pusan.add(new NavigationChartsTuple<String, Integer>(
                "Pusan Airport Diagram", R.drawable.pusan_airport_diagram));
        pusan.add(new NavigationChartsTuple<String, Integer>(
                "Pusan Korav North Departure", R.drawable.pusan_korav_north_departure));
        pusan.add(new NavigationChartsTuple<String, Integer>(
                "Pusan ILS RWY 32", R.drawable.pusan_ils_rwy_32));
        pusan.add(new NavigationChartsTuple<String, Integer>(
                "Pusan TACAN RWY 14", R.drawable.pusan_tacan_rwy_14));
        children.put(groups.get(13), pusan);

        groups.add("P`yong`taek Airbase");
        pyongtaek.add(new NavigationChartsTuple<String, Integer>(
                "P`yong`taek Osan 1 Departure", R.drawable.pyongtaek_airport_diagram));
        pyongtaek.add(new NavigationChartsTuple<String, Integer>(
                "P`yong`taek ILS RWY 34", R.drawable.pyongtaek_ils_rwy_34));
        pyongtaek.add(new NavigationChartsTuple<String, Integer>(
                "P`yong`taek TACAN RWY 16", R.drawable.pyongtaek_tacan_rwy_16));
        children.put(groups.get(14), pyongtaek);

        groups.add("Sachon Airbase");
        sachon.add(new NavigationChartsTuple<String, Integer>(
                "Sachon Airport Diagram", R.drawable.sachon_airport_diagram));
        sachon.add(new NavigationChartsTuple<String, Integer>(
                "Sachon 1 Departure", R.drawable.sachon_1_departure));
        sachon.add(new NavigationChartsTuple<String, Integer>(
                "Sachon ILS RWY 05L", R.drawable.sachon_ils_rwy_05l));
        sachon.add(new NavigationChartsTuple<String, Integer>(
                "Sachon ILS RWY 23R", R.drawable.sachon_ils_rwy_23r));
        sachon.add(new NavigationChartsTuple<String, Integer>(
                "Sachon TACAN RWY 05R", R.drawable.sachon_tacan_rwy_05r));
        sachon.add(new NavigationChartsTuple<String, Integer>(
                "Sachon TACAN RWY 23L", R.drawable.sachon_tacan_rwy_23l));
        children.put(groups.get(15), sachon);

        groups.add("Seosan (Haemi) Airbase");
        seosan.add(new NavigationChartsTuple<String, Integer>(
                "Seosan (Haemi) Airport Diagram", R.drawable.seosan_haemi_airport_diagram));
        seosan.add(new NavigationChartsTuple<String, Integer>(
                "Seosan (Haemi) 1 Departure", R.drawable.seosan_1_departure));
        seosan.add(new NavigationChartsTuple<String, Integer>(
                "Seosan (Haemi) ILS RWY 02R", R.drawable.seosan_haemi_ils_rwy_02r));
        seosan.add(new NavigationChartsTuple<String, Integer>(
                "Seosan (Haemi) TACAN RWY 02L", R.drawable.seosan_haemi_hi_tacan_rwy_02l));
        seosan.add(new NavigationChartsTuple<String, Integer>(
                "Seosan (Haemi) TACAN RWY 20L", R.drawable.seosan_haemi_hi_tacan_rwy_20l));
        seosan.add(new NavigationChartsTuple<String, Integer>(
                "Seosan (Haemi) TACAN RWY 20R", R.drawable.seosan_haemi_hi_tacan_rwy_20r));
        children.put(groups.get(16), seosan);

        groups.add("Seoul Airbase");
        seoul.add(new NavigationChartsTuple<String, Integer>(
                "Seoul Airport Diagram", R.drawable.seoul_airport_diagram));
        seoul.add(new NavigationChartsTuple<String, Integer>(
                "Seoul Hatch 1 Departure", R.drawable.seoul_hatch_1_departure));
        seoul.add(new NavigationChartsTuple<String, Integer>(
                "Seoul Noru 1 Departure", R.drawable.seoul_noru_1_departure));
        seoul.add(new NavigationChartsTuple<String, Integer>(
                "Seoul ILS RWY 19", R.drawable.seoul_ils_rwy_19));
        seoul.add(new NavigationChartsTuple<String, Integer>(
                "Seoul TACAN RWY 01", R.drawable.seoul_tacan_rwy_01));
        seoul.add(new NavigationChartsTuple<String, Integer>(
                "Seoul TACAN RWY 18", R.drawable.seoul_tacan_rwy_18));
        seoul.add(new NavigationChartsTuple<String, Integer>(
                "Seoul TACAN RWY 36", R.drawable.seoul_tacan_rwy_36));
        children.put(groups.get(17), seoul);

        groups.add("Sokcho Airbase");
        sokcho.add(new NavigationChartsTuple<String, Integer>(
                "Sokcho Airport Diagram", R.drawable.sokcho_airport_diagram));
        sokcho.add(new NavigationChartsTuple<String, Integer>(
                "Sokcho 1 Departure", R.drawable.sokcho_1_departure));
        sokcho.add(new NavigationChartsTuple<String, Integer>(
                "Sokcho ILS RWY 26", R.drawable.sokcho_ils_rwy_26));
        sokcho.add(new NavigationChartsTuple<String, Integer>(
                "Sokcho Circle to Land RWY 08", R.drawable.sokcho_circle_to_land_rwy_08));
        children.put(groups.get(18), sokcho);

        groups.add("Suwon Airbase");
        suwon.add(new NavigationChartsTuple<String, Integer>(
                "Suwon Airport Diagram", R.drawable.suwon_airport_diagram));
        suwon.add(new NavigationChartsTuple<String, Integer>(
                "Suwon 6 Departure", R.drawable.suwon_suwon_6_departure));
        suwon.add(new NavigationChartsTuple<String, Integer>(
                "Suwon ILS RWY 32L", R.drawable.suwon_ils_rwy_32l));
        suwon.add(new NavigationChartsTuple<String, Integer>(
                "Suwon TACAN 14L&14R", R.drawable.suwon_tacan_rwy_14l_14r));
        suwon.add(new NavigationChartsTuple<String, Integer>(
                "Suwon TACAN RWY 32R", R.drawable.suwon_tacan_rwy_32r));
        children.put(groups.get(19), suwon);

        groups.add("Taegu Airbase");
        taegu.add(new NavigationChartsTuple<String, Integer>(
                "Taegu Airport Diagram", R.drawable.taegu_airport_diagram));
        taegu.add(new NavigationChartsTuple<String, Integer>(
                "Taegu 6 Departure", R.drawable.taegu_taegu_6_departure));
        taegu.add(new NavigationChartsTuple<String, Integer>(
                "Taegu ILS RWY 32", R.drawable.taegu_ils_rwy_32));
        taegu.add(new NavigationChartsTuple<String, Integer>(
                "Taegu Circle to Land RWY 14", R.drawable.taegu_circle_to_land_rwy_14));
        children.put(groups.get(20), taegu);

        groups.add("Yechon Airbase");
        yechon.add(new NavigationChartsTuple<String, Integer>(
                "Yechon Airport Diagram", R.drawable.yechon_airport_diagram));
        yechon.add(new NavigationChartsTuple<String, Integer>(
                "Yechon Parot 5A Departure", R.drawable.yechon_parot_5a_departure));
        yechon.add(new NavigationChartsTuple<String, Integer>(
                "Yechon ILS RWY 26", R.drawable.yechon_ils_rwy_26));
        yechon.add(new NavigationChartsTuple<String, Integer>(
                "Yechon TACAN RWY 08", R.drawable.yechon_tacan_rwy_08));
        children.put(groups.get(21), yechon);

        this.southKoreaAirbaseList = groups;
        this.southKoreaHashMap = children;
    }
}
