package com.abhishek.yasma.ui.postList;

import com.abhishek.yasma.model.Post;
import com.abhishek.yasma.model.PostDataImpl;
import com.abhishek.yasma.repository.ApiRepositoryHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class PostListFragmentViewModelTest {

    @Mock
    private ApiRepositoryHelper helper;

    private TestScheduler testScheduler;

    @Mock
    private PostListViewContract contract;


    private PostListFragmentViewModel viewModel;
    private ArrayList<PostDataImpl> postList;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }


    @Before
    public void setUp() throws Exception {
        testScheduler = new TestScheduler();
        viewModel = new PostListFragmentViewModel(helper);
        viewModel.setContract(contract);
        postList = new ArrayList<>();


    }

    @Test
    public void startNetworkRequest() {


        doReturn(Single.just(postList)).when(helper).getPosts();

        viewModel.startNetworkRequest();
        testScheduler.triggerActions();

        verify(contract).onSuccess(postList);
    }

    @After
    public void tearDown() {
        viewModel = null;
        postList = null;
        contract = null;
    }
}