package com.oldgoat5.bmstacticalreference;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/*********************************************************************
 * Shows a list of South Korean charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class SouthKoreaChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayAdapter<String> adapter;
    private Dialog dialog;
    private ZoomImageView imageView;
    private ListView listView;
    private String[] airbases;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.south_korea_chart_fragment_layout, container, false);

        airbases = new String[]{"East-West Airstrips", "North-South Airstrips",
                "Chongju Airport Diagram", "Chongju Five Departure",
                "Chongju ILS RWY 23R", "Chongju TACAN RWY 05L",
                "Chongju TACAN RWY 05R", "Chongju TACAN RWY 23L",
                "Chongju Visual Approach", "Choongwon Airport Diagram",
                "Choongwon One Departure", "Choongwon ILS RWY 34R",
                "Choongwon TACAN 34L", "Choongwon TACAN RWY 16L",
                "Choongwon TACAN RWY 16R", "Hoengsong Airport Diagram",
                "Hoengson NOTAM", "Hoengsong ILS RWY 36",
                "Hoengsong Visual RWY 18", "Hoengsong Visual RWY 36",
                "Kangnung Airport Diagram", "Kangnung Kangwon One Departure",
                "Kangnun ILS RWY 26", "Kangnun Circle To Land RWY 08",
                "Kimhae Airport Diagram", "Kimhae Nakdong 3A Departure",
                "Kimhae Nakdong 4A Departure", "Kimhae ILS RWY 34",
                "Kimhae TACAN RWY 16", "Kimpo Airport Diagram",
                "Kimpo 1W & 1E Departure", "Kimpo ILS RWY 14L",
                "Kimpo ILS RWY 14R", "Kimpo ILS RWY 32L",
                "Kimpo ILS RWY 32R", "Kunsan Airport Diagram",
                "Kunsan Aladi One Departure", "Kunsan Coyote Three Departure",
                "Kunsan Patro Departure", "Kunsan ILS RWY 18",
                "Kunsan ILS RWY 36", "Kunsan Visual Approach",
                "Kwangju Airport Diagram", "Kwangju 3A Departure RWY 02",
                "Kwangju 4A Departure RWY 20", "Kwangju ILS RWY 02",
                "Kwangju ILS RWY 20", "Mandumi Airport Diagram",
                "Osan Airport Diagram", "Osan Draggin One Departure",
                "Osan Jet Yoke Departure", "Osan ILS RWY 09",
                "Osan ILS RWY 27", "Pohang Airport Diagram",
                "Pohang Posco One Departure", "Pohang ILS RWY 26",
                "Pohang TACAN RWY 08", "Pusan Airport Diagram",
                "Pusan Korav North Departure", "Pusan ILS RWY 32",
                "Pusan TACAN RWY 14", "Pyong`taek Airport Diagram",
                "Pyong`taek Osan One Departure", "Pyong`taek ILS RWY 34",
                "Pyong`taek TACAN RWY 16", "Sachon Airport Diagram",
                "Sachon One Departure", "Sachon ILS RWY 05L",
                "Sachon ILS RWY 23R", "Sachon TACAN RWY 05R",
                "Sachon TACAN RWY 23L", "Seosan/Haemi Airport Diagram",
                "Seosan/Haemi One Departure", "Seosan/Haemi ILS RWY 02R",
                "Seosan/Haemi TACAN RWY 02L", "Seosan/Haemi TACAN RWY 20L",
                "Seosan/Haemi TACAN RWY 20R", "Seoul Airport Diagram",
                "Seoul Noru One Departure", "Seoul ILS RWY 19",
                "Seoul TACAN RWY 01", "Seoul TACAN RWY 18",
                "Seoul TACAN RWY 36", "Sokcho Airport Diagram",
                "Sokcho NOTAM", "Sokcho One Departure",
                "Sokcho ILS RWY 18", "Sokcho Visual RWY 18",
                "Sokcho Visual RWY 36", "Suwon Airport Diagram",
                "Suwon Six Departure", "Suwon ILS RWY 32L",
                "Suwon TACAN 14L &14R", "Suwon TACAN RWY 32R",
                "Taegu Airport Diagram", "Taegu Six Departure",
                "Taegu ILS RWY 32", "Taegu Circle To Land RWY 14",
                "Yechon Airport Diagram", "Yechon Solty 5A Departure",
                "Yechon ILS RWY 26", "Yechon TACAN RWY 8"};

        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,
                airbases);

        listView = (ListView) view.findViewById(R.id.south_korea_fragment_list_view);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        dialog = new Dialog(CONTEXT);
        imageView = new ZoomImageView(CONTEXT);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id)
            {
                Log.d("South Korea position: ", Integer.toString(position));

                switch (position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.south_korea_east_west_airstrips);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[0]);
                        dialog.show();
                        break;

                    case 1:
                        imageView.setImageResource(R.drawable.south_korea_north_south_airstrips);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[1]);
                        dialog.show();
                        break;

                    case 2:
                        imageView.setImageResource(R.drawable.chongju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[2]);
                        dialog.show();
                        break;

                    case 3:
                        imageView.setImageResource(R.drawable.chongju_five_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[3]);
                        dialog.show();
                        break;

                    case 4:
                        imageView.setImageResource(R.drawable.chongju_ils_rwy_23r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[4]);
                        dialog.show();
                        break;

                    case 5:
                        imageView.setImageResource(R.drawable.chongju_tacan_rwy_05l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[5]);
                        dialog.show();
                        break;

                    case 6:
                        imageView.setImageResource(R.drawable.chongju_tacan_rwy_05r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[6]);
                        dialog.show();
                        break;

                    case 7:
                        imageView.setImageResource(R.drawable.chongju_tacan_rwy_23l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[7]);
                        dialog.show();
                        break;

                    case 8:
                        imageView.setImageResource(R.drawable.chongju_visual);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[8]);
                        dialog.show();
                        break;

                    case 9:
                        imageView.setImageResource(R.drawable.choongwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[9]);
                        dialog.show();
                        break;

                    case 10:
                        imageView.setImageResource(R.drawable.choongwon_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[19]);
                        dialog.show();
                        break;

                    case 11:
                        imageView.setImageResource(R.drawable.choongwon_ils_rwy_34r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[11]);
                        dialog.show();
                        break;

                    case 12:
                        imageView.setImageResource(R.drawable.choongwon_tacan_34l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[12]);
                        dialog.show();
                        break;

                    case 13:
                        imageView.setImageResource(R.drawable.choongwon_tacan_rwy_16l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[13]);
                        dialog.show();
                        break;

                    case 14:
                        imageView.setImageResource(R.drawable.choongwon_tacan_rwy_16r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[14]);
                        dialog.show();
                        break;

                    case 15:
                        imageView.setImageResource(R.drawable.hoengsong_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[15]);
                        dialog.show();
                        break;

                    case 16:
                        imageView.setImageResource(R.drawable.hoengsong_notam);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[16]);
                        dialog.show();
                        break;

                    case 17:
                        imageView.setImageResource(R.drawable.hoengsong_ils_rwy_36);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[17]);
                        dialog.show();
                        break;

                    case 18:
                        imageView.setImageResource(R.drawable.hoengsong_visual_rwy_18);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[18]);
                        dialog.show();
                        break;

                    case 19:
                        imageView.setImageResource(R.drawable.hoengsong_visual_rwy_36);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[19]);
                        dialog.show();
                        break;

                    case 20:
                        imageView.setImageResource(R.drawable.kangnung_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[20]);
                        dialog.show();
                        break;

                    case 21:
                        imageView.setImageResource(R.drawable.kangnung_kangwon_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[21]);
                        dialog.show();
                        break;

                    case 22:
                        imageView.setImageResource(R.drawable.kangnung_ils_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[22]);
                        dialog.show();
                        break;

                    case 23:
                        imageView.setImageResource(R.drawable.kangnung_circle_to_land_rwy_08);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[23]);
                        dialog.show();
                        break;

                    case 24:
                        imageView.setImageResource(R.drawable.kimhae_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[24]);
                        dialog.show();
                        break;

                    case 25:
                        imageView.setImageResource(R.drawable.kimhae_nakdong_3a_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[25]);
                        dialog.show();
                        break;

                    case 26:
                        imageView.setImageResource(R.drawable.kimhae_nakdong_4a_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[26]);
                        dialog.show();
                        break;

                    case 27:
                        imageView.setImageResource(R.drawable.kimhae_ils_rwy_34);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[27]);
                        dialog.show();
                        break;

                    case 28:
                        imageView.setImageResource(R.drawable.kimhae_tacan_rwy_16);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[28]);
                        dialog.show();
                        break;

                    case 29:
                        imageView.setImageResource(R.drawable.kimpo_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[29]);
                        dialog.show();
                        break;

                    case 30:
                        imageView.setImageResource(R.drawable.kimpo_1w_1e_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[30]);
                        dialog.show();
                        break;

                    case 31:
                        imageView.setImageResource(R.drawable.kimpo_ils_rwy_14l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[31]);
                        dialog.show();
                        break;

                    case 32:
                        imageView.setImageResource(R.drawable.kimpo_ils_rwy_14r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[32]);
                        dialog.show();
                        break;

                    case 33:
                        imageView.setImageResource(R.drawable.kimpo_ils_rwy_32l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[33]);
                        dialog.show();
                        break;

                    case 34:
                        imageView.setImageResource(R.drawable.kimpo_ils_rwy_32r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[34]);
                        dialog.show();
                        break;

                    case 35:
                        imageView.setImageResource(R.drawable.kunsan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[36]);
                        dialog.show();
                        break;

                    case 36:
                        imageView.setImageResource(R.drawable.kunsan_aladi_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[37]);
                        dialog.show();
                        break;

                    case 37:
                        imageView.setImageResource(R.drawable.kunsan_coyote_three_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[37]);
                        dialog.show();
                        break;

                    case 38:
                        imageView.setImageResource(R.drawable.kunsan_patro_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[38]);
                        dialog.show();
                        break;

                    case 39:
                        imageView.setImageResource(R.drawable.kunsan_ils_rwy_18);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[39]);
                        dialog.show();
                        break;

                    case 40:
                        imageView.setImageResource(R.drawable.kunsan_ils_rwy_36);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[40]);
                        dialog.show();
                        break;

                    case 41:
                        imageView.setImageResource(R.drawable.kunsan_visual_18_36);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[41]);
                        dialog.show();
                        break;

                    case 42:
                        imageView.setImageResource(R.drawable.kwangju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[42]);
                        dialog.show();
                        break;

                    case 43:
                        imageView.setImageResource(R.drawable.kwangju_3a_departure_rwy_02);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[43]);
                        dialog.show();
                        break;

                    case 44:
                        imageView.setImageResource(R.drawable.kwangju_4a_departure_rwy_20);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[44]);
                        dialog.show();
                        break;

                    case 45:
                        imageView.setImageResource(R.drawable.kwangju_ils_rwy_02);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[45]);
                        dialog.show();
                        break;

                    case 46:
                        imageView.setImageResource(R.drawable.kwangju_ils_rwy_20);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[46]);
                        dialog.show();
                        break;

                    case 47:
                        imageView.setImageResource(R.drawable.mandumi_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[47]);
                        dialog.show();
                        break;

                    case 48:
                        imageView.setImageResource(R.drawable.osan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[48]);
                        dialog.show();
                        break;

                    case 49:
                        imageView.setImageResource(R.drawable.osan_draggin_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[49]);
                        dialog.show();
                        break;

                    case 50:
                        imageView.setImageResource(R.drawable.osan_jet_yoke_four_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[50]);
                        dialog.show();
                        break;

                    case 51:
                        imageView.setImageResource(R.drawable.osan_ils_rwy_09);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[51]);
                        dialog.show();
                        break;

                    case 52:
                        imageView.setImageResource(R.drawable.osan_ils_rwy_27);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[52]);
                        dialog.show();
                        break;

                    case 53:
                        imageView.setImageResource(R.drawable.pohang_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[53]);
                        dialog.show();
                        break;

                    case 54:
                        imageView.setImageResource(R.drawable.pohang_posco_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[54]);
                        dialog.show();
                        break;

                    case 55:
                        imageView.setImageResource(R.drawable.pohang_ils_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[55]);
                        dialog.show();
                        break;

                    case 56:
                        imageView.setImageResource(R.drawable.pohang_tacan_rwy_08);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[56]);
                        dialog.show();
                        break;

                    case 57:
                        imageView.setImageResource(R.drawable.pusan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[57]);
                        dialog.show();
                        break;

                    case 58:
                        imageView.setImageResource(R.drawable.pusan_korav_north_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[58]);
                        dialog.show();
                        break;

                    case 59:
                        imageView.setImageResource(R.drawable.pusan_ils_rwy_32);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[59]);
                        dialog.show();
                        break;

                    case 60:
                        imageView.setImageResource(R.drawable.pusan_tacan_rwy_14);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[60]);
                        dialog.show();
                        break;

                    case 61:
                        imageView.setImageResource(R.drawable.pyongtaek_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[61]);
                        dialog.show();
                        break;

                    case 62:
                        imageView.setImageResource(R.drawable.pyongtaek_osan_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[62]);
                        dialog.show();
                        break;

                    case 63:
                        imageView.setImageResource(R.drawable.pyongtaek_ils_rwy_34);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[63]);
                        dialog.show();
                        break;

                    case 64:
                        imageView.setImageResource(R.drawable.pyongtaek_tacan_rwy_16);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[64]);
                        dialog.show();
                        break;

                    case 65:
                        imageView.setImageResource(R.drawable.sachon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[65]);
                        dialog.show();
                        break;

                    case 66:
                        imageView.setImageResource(R.drawable.sachon_one_deprture);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[66]);
                        dialog.show();
                        break;

                    case 67:
                        imageView.setImageResource(R.drawable.sachon_ils_rwy_05l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[68]);
                        dialog.show();
                        break;

                    case 68:
                        imageView.setImageResource(R.drawable.sachon_ils_rwy_23r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[69]);
                        dialog.show();
                        break;

                    case 69:
                        imageView.setImageResource(R.drawable.sachon_tacan_rwy_05r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[69]);
                        dialog.show();
                        break;

                    case 70:
                        imageView.setImageResource(R.drawable.sachon_tacan_rwy_23l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[70]);
                        dialog.show();
                        break;

                    case 71:
                        imageView.setImageResource(R.drawable.seosan_haemi_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[71]);
                        dialog.show();
                        break;

                    case 72:
                        imageView.setImageResource(R.drawable.seosan_haemi_seosan_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[72]);
                        dialog.show();
                        break;

                    case 73:
                        imageView.setImageResource(R.drawable.seosan_haemi_ils_rwy_02r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[73]);
                        dialog.show();
                        break;

                    case 74:
                        imageView.setImageResource(R.drawable.seosan_haemi_hi_tacan_rwy_02l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[74]);
                        dialog.show();
                        break;

                    case 75:
                        imageView.setImageResource(R.drawable.seosan_haemi_hi_tacan_rwy_20l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[75]);
                        dialog.show();
                        break;

                    case 76:
                        imageView.setImageResource(R.drawable.seosan_haemi_hi_tacan_rwy_20r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[76]);
                        dialog.show();
                        break;

                    case 77:
                        imageView.setImageResource(R.drawable.seoul_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[77]);
                        dialog.show();
                        break;

                    case 78:
                        imageView.setImageResource(R.drawable.seoul_noru_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[78]);
                        dialog.show();
                        break;

                    case 79:
                        imageView.setImageResource(R.drawable.seoul_ils_rwy_19);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[79]);
                        dialog.show();
                        break;

                    case 80:
                        imageView.setImageResource(R.drawable.seoul_tacan_rwy_01);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[80]);
                        dialog.show();
                        break;

                    case 81:
                        imageView.setImageResource(R.drawable.seoul_tacan_rwy_18);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[81]);
                        dialog.show();
                        break;

                    case 82:
                        imageView.setImageResource(R.drawable.seoul_tacan_rwy_36);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[82]);
                        dialog.show();
                        break;

                    case 83:
                        imageView.setImageResource(R.drawable.sokcho_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[83]);
                        dialog.show();
                        break;

                    case 84:
                        imageView.setImageResource(R.drawable.sokcho_notam);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[84]);
                        dialog.show();
                        break;

                    case 85:
                        imageView.setImageResource(R.drawable.sokcho_one_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[85]);
                        dialog.show();
                        break;

                    case 86:
                        imageView.setImageResource(R.drawable.sokcho_ils_rwy_18);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[86]);
                        dialog.show();
                        break;

                    case 87:
                        imageView.setImageResource(R.drawable.sokcho_visual_rwy_18);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[87]);
                        dialog.show();
                        break;

                    case 88:
                        imageView.setImageResource(R.drawable.sokcho_visual_rwy_36);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[88]);
                        dialog.show();
                        break;

                    case 89:
                        imageView.setImageResource(R.drawable.suwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[89]);
                        dialog.show();
                        break;

                    case 90:
                        imageView.setImageResource(R.drawable.suwon_six_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[90]);
                        dialog.show();
                        break;

                    case 91:
                        imageView.setImageResource(R.drawable.suwon_ils_rwy_32l);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[91]);
                        dialog.show();
                        break;

                    case 92:
                        imageView.setImageResource(R.drawable.suwon_tacan_rwy_14l_14r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[92]);
                        dialog.show();
                        break;

                    case 93:
                        imageView.setImageResource(R.drawable.suwon_tacan_rwy_32r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[93]);
                        dialog.show();
                        break;

                    case 94:
                        imageView.setImageResource(R.drawable.taegu_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[94]);
                        dialog.show();
                        break;

                    case 95:
                        imageView.setImageResource(R.drawable.taegu_six_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[95]);
                        dialog.show();
                        break;

                    case 96:
                        imageView.setImageResource(R.drawable.taegu_ils_rwy_32);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[96]);
                        dialog.show();
                        break;

                    case 97:
                        imageView.setImageResource(R.drawable.taegu_circle_to_land_rwy_14);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[97]);
                        dialog.show();
                        break;

                    case 98:
                        imageView.setImageResource(R.drawable.yechon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[98]);
                        dialog.show();
                        break;

                    case 99:
                        imageView.setImageResource(R.drawable.yechon_solty_5a_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[99]);
                        dialog.show();
                        break;

                    case 100:
                        imageView.setImageResource(R.drawable.yechon_ils_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[100]);
                        dialog.show();
                        break;

                    case 101:
                        imageView.setImageResource(R.drawable.yechon_tacan_rwy_08);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[101]);
                        dialog.show();
                        break;
                }
                // Return true to consume the click event. In this case the
                // onListItemClick listener is not called anymore.
                return false;
            }
        });

        listView.setAdapter(adapter);

        return view;
    }
}
