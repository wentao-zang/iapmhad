<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="WCS-X" prop="x">
      <el-input v-model="dataForm.x" placeholder="WCS-X"></el-input>
    </el-form-item>
    <el-form-item label="WCS-Y" prop="y">
      <el-input v-model="dataForm.y" placeholder="WCS-Y"></el-input>
    </el-form-item>
    <el-form-item label="WCS-Z" prop="z">
      <el-input v-model="dataForm.z" placeholder="WCS-Z"></el-input>
    </el-form-item>
    <el-form-item label="" prop="x1">
      <el-input v-model="dataForm.x1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="x11">
      <el-input v-model="dataForm.x11" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="z11">
      <el-input v-model="dataForm.z11" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="v2">
      <el-input v-model="dataForm.v2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="v3">
      <el-input v-model="dataForm.v3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="a1">
      <el-input v-model="dataForm.a1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="a2">
      <el-input v-model="dataForm.a2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="a3">
      <el-input v-model="dataForm.a3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="a4">
      <el-input v-model="dataForm.a4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="a5">
      <el-input v-model="dataForm.a5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="a6">
      <el-input v-model="dataForm.a6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          x: '',
          y: '',
          z: '',
          x1: '',
          x11: '',
          z11: '',
          v2: '',
          v3: '',
          a1: '',
          a2: '',
          a3: '',
          a4: '',
          a5: '',
          a6: '',
          time: ''
        },
        dataRule: {
          x: [
            { required: true, message: 'WCS-X不能为空', trigger: 'blur' }
          ],
          y: [
            { required: true, message: 'WCS-Y不能为空', trigger: 'blur' }
          ],
          z: [
            { required: true, message: 'WCS-Z不能为空', trigger: 'blur' }
          ],
          x1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          x11: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          z11: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          v2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          v3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          a1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          a2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          a3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          a4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          a5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          a6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/posinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.x = data.posinfo.x
                this.dataForm.y = data.posinfo.y
                this.dataForm.z = data.posinfo.z
                this.dataForm.x1 = data.posinfo.x1
                this.dataForm.x11 = data.posinfo.x11
                this.dataForm.z11 = data.posinfo.z11
                this.dataForm.v2 = data.posinfo.v2
                this.dataForm.v3 = data.posinfo.v3
                this.dataForm.a1 = data.posinfo.a1
                this.dataForm.a2 = data.posinfo.a2
                this.dataForm.a3 = data.posinfo.a3
                this.dataForm.a4 = data.posinfo.a4
                this.dataForm.a5 = data.posinfo.a5
                this.dataForm.a6 = data.posinfo.a6
                this.dataForm.time = data.posinfo.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/posinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'x': this.dataForm.x,
                'y': this.dataForm.y,
                'z': this.dataForm.z,
                'x1': this.dataForm.x1,
                'x11': this.dataForm.x11,
                'z11': this.dataForm.z11,
                'v2': this.dataForm.v2,
                'v3': this.dataForm.v3,
                'a1': this.dataForm.a1,
                'a2': this.dataForm.a2,
                'a3': this.dataForm.a3,
                'a4': this.dataForm.a4,
                'a5': this.dataForm.a5,
                'a6': this.dataForm.a6,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
