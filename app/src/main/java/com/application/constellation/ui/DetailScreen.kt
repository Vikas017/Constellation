package com.application.constellation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.constellation.data.DataHolder
import com.application.constellation.ui.theme.ConstellationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConstellationDetail(dataHolder: DataHolder) {
    Scaffold(
        topBar = {
            Text(
                text = dataHolder.title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                letterSpacing = 6.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(4.dp)
        ) {
            item {

                ShowTIfNotNull(text = dataHolder.para1)
                ShowImage(img = dataHolder.headerImg, desc = dataHolder.title)
                ShowTIfNotNull(text = dataHolder.para2)
            }
            item {
                ShowImage(img = dataHolder.logoImg, desc = dataHolder.title)
                ShowTIfNotNull(text = dataHolder.para3)
            }
            item {
                ShowImage(img = dataHolder.img, desc = dataHolder.title)
                ShowTIfNotNull(text = dataHolder.para4)
            }
        }
    }
}

@Composable
fun ShowTIfNotNull(text: String?) {
    if (!text.isNullOrEmpty()) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ShowImage(img: Int, desc: String) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(2.dp, Color.Black),
        shadowElevation = 15.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = img),
            contentDescription = desc,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
    }
}

@Preview
@Composable
fun Preview() {
    ConstellationTheme {
        //ConstellationDetail()
    }
}
