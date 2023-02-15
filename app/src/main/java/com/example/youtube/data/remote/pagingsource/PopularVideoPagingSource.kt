package com.example.youtube.data.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.youtube.data.model.PopularVideo
import com.example.youtube.data.remote.apiservices.VideoCategoryApiService
import java.io.IOException

class PopularVideoPagingSource(
    private val service: VideoCategoryApiService,
    private val regionCode: String,
    private val chart: String,
    private val part: String
) :
    PagingSource<String, PopularVideo>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, PopularVideo> {
        val page = params.key ?: STARTING_PAGE_TOKEN
        return try {
            val response = service.fetchVideo(regionCode, chart, part, page)

            val nextKey = if (response.items.isEmpty()) null else response.nextPageToken
            val prevKey = if (page == STARTING_PAGE_TOKEN) null else response.prevPageToken

            LoadResult.Page(
                data = response.items,
                nextKey = nextKey,
                prevKey = prevKey
            )

        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, PopularVideo>): String? {
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey
        }
        return null
    }

    companion object {
        private const val STARTING_PAGE_TOKEN = ""
    }
}