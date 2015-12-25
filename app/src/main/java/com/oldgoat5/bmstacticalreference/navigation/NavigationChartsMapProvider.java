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
    private ArrayList<String> southKoreaAirbaseList;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> southKoreaHashMap;

    public ArrayList<String> getSouthKoreaAirbaseList()
    {
        return this.southKoreaAirbaseList;
    }

    public HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> getSouthKoreaHashMap()
    {
        return this.southKoreaHashMap;
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
