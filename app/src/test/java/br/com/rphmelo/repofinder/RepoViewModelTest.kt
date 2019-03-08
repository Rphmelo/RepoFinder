package br.com.rphmelo.repofinder

import br.com.rphmelo.repofinder.data.model.Repo
import br.com.rphmelo.repofinder.data.model.RepoOwner
import br.com.rphmelo.repofinder.data.model.RepoResponse
import br.com.rphmelo.repofinder.data.model.RepoSearchRequest
import br.com.rphmelo.repofinder.data.repository.RepoRepository
import br.com.rphmelo.repofinder.ui.RepoViewModel
import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executors
import org.junit.Rule
import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExtendWith(InstantExecutorExtension::class)
class RepoViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockRepository: RepoRepository

    @Mock
    private var executor = Executors.newSingleThreadExecutor()

    private lateinit var repoViewModel: RepoViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repoViewModel = RepoViewModel(mockRepository, executor)
    }

    @Test
    fun should_assert_that_searchRepos_was_called_successfully() {
        val repoSearchRequest = RepoSearchRequest("language:java", "stars", 1)
        val repoOwnerFake = RepoOwner("", "", "")
        val repoFake = Repo(
                "Raphael",
                "",
                "",
                "",
                "",
                "",
                "",
                1,
                1,
                "",
                repoOwnerFake,
                1,
                false
        )
        val repoResponse = RepoResponse(12, false, listOf(repoFake))

        val observable = Observable.just(repoResponse)
        Mockito.`when`(mockRepository.searchRepos(repoSearchRequest))
                .thenReturn(observable)

        repoViewModel.searchRepos(repoSearchRequest)

        observable.test()
                .assertResult(repoResponse)

    }
}
