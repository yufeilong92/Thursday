package com.xuechuan.xcedu.fragment.bank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xuechuan.xcedu.R;
import com.xuechuan.xcedu.base.BaseFragment;
import com.xuechuan.xcedu.base.DataMessageVo;
import com.xuechuan.xcedu.event.DayHomeEvent;
import com.xuechuan.xcedu.ui.bank.AtricleListNewActivity;
import com.xuechuan.xcedu.ui.bank.CaseOrderTestActivity;
import com.xuechuan.xcedu.ui.bank.GmFreeQuestionActivity;
import com.xuechuan.xcedu.ui.bank.GmMockTestActivity;
import com.xuechuan.xcedu.ui.bank.GmSpecialListActivity;
import com.xuechuan.xcedu.ui.bank.OrderTestActivity;
import com.xuechuan.xcedu.ui.home.SpecasListActivity;
import com.xuechuan.xcedu.utils.T;
import com.xuechuan.xcedu.vo.DayHomeBeanVo;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: CaseNewFragment
 * @Package com.xuechuan.xcedu.fragment.bank
 * @Description: 最新案例界面
 * @author: L-BackPacker
 * @date: 2018.12.04 下午 4:14
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018.12.04
 */
public class CaseNewFragment extends BaseFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView mTvBanknewDoNumber;
    private TextView mTvBanknewAllNumber;
    private TextView mTvBanknewRightNumber;
    private LinearLayout mLlBanknewFree;
    private LinearLayout mLlBanknewSpecial;
    private LinearLayout mLlBanknewOrder;
    private TextView mTvBanknewErrorList;
    private TextView mTvBanknewFavoriteList;
    private TextView mTvBanknewNoteList;
    private LinearLayout mLlBanknewPractice;
    private LinearLayout mLlBanknewExam;
    private LinearLayout mLlBanknewError;
    private LinearLayout mLlBanknewFavaoite;
    private LinearLayout mLlBanknewNote;
    private Context mContext;
    private TextView mTvDayExecistTitle;
    private LinearLayout mLiGmDayExecrise;

    public static CaseNewFragment newInstance(String param1, String param2) {
        CaseNewFragment fragment = new CaseNewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_case_new, container, false);
        initView(view);
        return view;
    }*/

    @Override
    protected int initInflateView() {
        return R.layout.fragment_case_new;
    }

    @Override
    protected void initCreateView(View view, Bundle savedInstanceState) {
        initView(view);
    }


    private void initView(View view) {
        mContext = getActivity();
        mTvBanknewDoNumber = (TextView) view.findViewById(R.id.tv_banknew_do_number);
        mTvBanknewAllNumber = (TextView) view.findViewById(R.id.tv_banknew_all_number);
        mTvBanknewRightNumber = (TextView) view.findViewById(R.id.tv_banknew_right_number);
        mLlBanknewFree = (LinearLayout) view.findViewById(R.id.ll_banknew_free);
        mLlBanknewFree.setOnClickListener(this);
        mLlBanknewSpecial = (LinearLayout) view.findViewById(R.id.ll_banknew_special);
        mLlBanknewSpecial.setOnClickListener(this);
        mLlBanknewOrder = (LinearLayout) view.findViewById(R.id.ll_banknew_order);
        mLlBanknewOrder.setOnClickListener(this);
        mTvBanknewErrorList = (TextView) view.findViewById(R.id.tv_banknew_error_list);
        mTvBanknewFavoriteList = (TextView) view.findViewById(R.id.tv_banknew_favorite_list);
        mTvBanknewNoteList = (TextView) view.findViewById(R.id.tv_banknew_note_list);
        mLlBanknewPractice = (LinearLayout) view.findViewById(R.id.ll_banknew_practice);
        mLlBanknewPractice.setOnClickListener(this);
        mLlBanknewExam = (LinearLayout) view.findViewById(R.id.ll_banknew_exam);
        mLlBanknewExam.setOnClickListener(this);
        mLlBanknewError = (LinearLayout) view.findViewById(R.id.ll_banknew_error);
        mLlBanknewError.setOnClickListener(this);
        mLlBanknewFavaoite = (LinearLayout) view.findViewById(R.id.ll_banknew_favaoite);
        mLlBanknewFavaoite.setOnClickListener(this);
        mLlBanknewNote = (LinearLayout) view.findViewById(R.id.ll_banknew_note);
        mLlBanknewNote.setOnClickListener(this);
        mTvDayExecistTitle = (TextView) view.findViewById(R.id.tv_day_execist_title);
        mTvDayExecistTitle.setOnClickListener(this);
        mLiGmDayExecrise = (LinearLayout) view.findViewById(R.id.li_gm_day_execrise);
        mLiGmDayExecrise.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_banknew_practice://章节练习
                Intent intent = AtricleListNewActivity.newInstance(mContext, DataMessageVo.COURESID_CASE, "1");
                intent.putExtra(AtricleListNewActivity.CSTR_EXTRA_TITLE_STR, getStrWithId(R.string.Chapter_practice));
                startActivity(intent);
                break;
            case R.id.ll_banknew_exam://模拟考试
                Intent intent3 = GmMockTestActivity.newInstance(mContext, DataMessageVo.COURESID_CASE);
                intent3.putExtra(GmMockTestActivity.CSTR_EXTRA_TITLE_STR, getStrWithId(R.string.mokeexam));
                startActivity(intent3);
                break;
            case R.id.ll_banknew_free://自由组卷
                Intent intent6 = GmFreeQuestionActivity.newInstance(mContext, DataMessageVo.COURESID_CASE);
                intent6.putExtra(GmFreeQuestionActivity.CSTR_EXTRA_TITLE_STR, getStrWithId(R.string.skill_free_composition));
                mContext.startActivity(intent6);
                break;
            case R.id.ll_banknew_special://专项练习
                Intent intent4 = GmSpecialListActivity.newInstance(mContext, DataMessageVo.COURESID_CASE);
                intent4.putExtra(SpecasListActivity.CSTR_EXTRA_TITLE_STR, getStrWithId(R.string.special));
                startActivity(intent4);

                break;
            case R.id.ll_banknew_order://顺序练习
                Intent order = CaseOrderTestActivity.start_Intent(mContext, DataMessageVo.COURESID_CASE);
                order.putExtra(OrderTestActivity.CSTR_EXTRA_TITLE_STR, getStrWithId(R.string.sequential_exercise));
                mContext.startActivity(order);
                break;
            case R.id.ll_banknew_error://错题集合
                break;
            case R.id.ll_banknew_favaoite://收藏夹
                break;
            case R.id.ll_banknew_note://笔记
                break;
            case R.id.li_gm_day_execrise://每日一练

                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void DayHomeEvent(DayHomeEvent event) {
        List<DayHomeBeanVo> data = event.getData();
        for (int i = 0; i < data.size(); i++) {
            DayHomeBeanVo dayHomeBeanVo = data.get(i);
            if (dayHomeBeanVo.getCourseid() == DataMessageVo.ORDER_THREE) {
                initDayData(dayHomeBeanVo);
            }
        }
    }

    private void initDayData(DayHomeBeanVo vo) {
        mTvDayExecistTitle.setText(vo.getKeyword());
    }
}
