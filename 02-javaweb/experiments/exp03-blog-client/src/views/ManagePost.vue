<template>
  <div class="manage-post pad-all-10">
    <el-table highlight-current-row :data="data" stripe style="width: 100%">
      <el-table-column prop="createDate" label="发表日期" sortable />
      <el-table-column prop="title" label="文章标题" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" type="primary" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog v-model="dialog" title="⚠警告" width="30%" align-center>
      <span>{{ dialogTitle }}</span>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialog = false">取消</el-button>
          <el-button type="primary" @click="deletePost">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { ElMessage } from "element-plus";
import { useCookies } from "@vueuse/integrations/useCookies";
import service from "@/request";

const router = useRouter();

const { data } = await service.post("/get/posts", { id: useCookies().get("signed") });

let dialog = ref(false);
let dialogTitle = ref("");

function handleEdit(index, row) {
  router.push({ path: "/h/edit", query: { id: row.id } });
}

let post = ref();

function handleDelete(index, row) {
  dialog.value = true;
  post.value = row;
  dialogTitle.value = `是否删除 ${row.title} ？`;
}

function deletePost() {
  service
    .post("/delete/post", post.value)
    .then(res => {
      ElMessage({
        center: true,
        message: `删除成功！`,
        type: "success"
      });
      dialog.value = false;
    })
    .catch(err => {
      ElMessage({
        center: true,
        message: `删除失败！`,
        type: "error"
      });
      dialog.value = false;
    });
}
</script>

<style scoped></style>
