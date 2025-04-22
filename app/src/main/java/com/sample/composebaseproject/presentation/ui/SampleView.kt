package com.sample.composebaseproject.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.sample.composebaseproject.presentation.DogImageUiState
import com.sample.composebaseproject.presentation.MainViewModel

@Composable
fun SampleView(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state) {
            is DogImageUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(100.dp)
                )
            }
            is DogImageUiState.Failure -> {
                Text("이미지 로딩 실패")
            }
            is DogImageUiState.Empty -> {
                Text("이미지가 없습니다")
            }
            is DogImageUiState.Success -> {
                AsyncImage(
                    model = (state as DogImageUiState.Success).imageUrl,
                    contentDescription = "강아지 이미지",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { viewModel.updateDogImage() }) {
            Text("이미지 업데이트")
        }
    }
}

@Composable
@Preview
fun SampleViewPreview() {
    // Preview를 위한 목업 뷰모델 생성은 실제 뷰모델 주입 구조와 맞지 않으므로 생략
}
