package com.application.constellation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.constellation.data.DataHolder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConstellationHome(list: List<DataHolder>,viewModel: ViewModel, onItemClick: () -> Unit) {
    Scaffold(
        topBar = {
            Text(
                text = "Constellations",//constellation fact
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                letterSpacing = 6.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)) {
            items(list.size) {
                ConstellationItem(list[it], viewModel, onItemClick)
            }
        }
    }
}

@Composable
fun ConstellationItem(dataHolder: DataHolder, viewModel: ViewModel, onItemClick: ()-> Unit) {
    Surface(
        border = BorderStroke(0.1.dp, Color.Black),
        shape = RectangleShape,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(painter = painterResource(dataHolder.img),
                    contentDescription = dataHolder.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = dataHolder.title,
                    style = MaterialTheme.typography.labelMedium
                ) //can add column for short description
            }
            IconButton(onClick = {
                viewModel.setItem(dataHolder)
                onItemClick()
            }
            ) {
                Icon(imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = null)
            }
        }
    }
}