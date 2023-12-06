package com.example.qlct.old.fragments;

import androidx.fragment.app.Fragment;

//import com.example.qlct.databinding.FragmentSoChiTieuViewBinding;


public class SoChiTieuFragment extends Fragment {
//    FragmentSoChiTieuBinding binding;
//    ArrayList<String> listVi = new ArrayList<>();
//    Calendar c;
//    Bundle bundle;
//    ViTienSql viTienSql;
//    FirebaseAuth auth;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_so_chi_tieu, container, false);
//        binding = FragmentSoChiTieuBinding.bind(view);
//        initView();
//        return view;
//    }
//    private void initView(){
//        viTienSql = new ViTienSql(getActivity(), ViTienSql.TableName, null, 1);
//        auth = FirebaseAuth.getInstance();
//        FirebaseUser user = auth.getCurrentUser();
////        try {
////            binding.txtSoDu.setText(String.valueOf(viTienSql.getViTien(user.getEmail()).get(0).getSoTien()));
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//        binding.tablayoutCT.addTab(binding.tablayoutCT.newTab().setText("Tháng trước"));
//        binding.tablayoutCT.addTab(binding.tablayoutCT.newTab().setText("Hiện tại"));
//        binding.tablayoutCT.addTab(binding.tablayoutCT.newTab().setText("Tương lai"));
//        c = Calendar.getInstance();
//        c = Calendar.getInstance();
//        int month = c.get(Calendar.MONTH);
//        int year = c.get(Calendar.YEAR);
//        if (month == 1) {
//            month = 12;
//            year--;
//        } else {
//            month = month - 1;
//        }
//        replaceFragment(new SoChiTieuViewFragment(),month,year);
//        listVi.add("Tiền mặt");
//        listVi.add("Ngân hàng");
//        ArrayAdapter<String> viAdapter = new ArrayAdapter<>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listVi);
//        binding.tablayoutCT.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                if(tab.getText().toString().contentEquals("Tháng trước")) {
//                    c = Calendar.getInstance();
//                    int month = c.get(Calendar.MONTH);
//                    int year = c.get(Calendar.YEAR);
//                    if (month == 1) {
//                        month = 12;
//                        year--;
//                    } else {
//                        month = month - 1;
//                    }
//                    replaceFragment(new SoChiTieuViewFragment(),month,year);
//                } else if(tab.getText().toString().contentEquals("Hiện tại")) {
//                        c = Calendar.getInstance();
//                        replaceFragment(new SoChiTieuViewFragment(), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
//                } else {
//                    c = Calendar.getInstance();
//                    int month = c.get(Calendar.MONTH);
//                    int year = c.get(Calendar.YEAR);
//                    if (month == 12) {
//                        month = 1;
//                        year++;
//                    } else {
//                        month = month + 1;
//                    }
//                    replaceFragment(new SoChiTieuViewFragment(), month, year);
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//    private void replaceFragment(Fragment fragment, int month, int year) {
//        bundle = new Bundle();
//        bundle.putInt("month", month);
//        bundle.putInt("year", year);
//        fragment.setArguments(bundle);
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.framelayoutCT, fragment);
//        fragmentTransaction.commit();
//    }
}