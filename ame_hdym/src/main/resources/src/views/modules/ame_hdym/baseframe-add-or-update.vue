<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="stationcode">
      <el-input v-model="dataForm.stationcode" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="x">
      <el-input v-model="dataForm.x" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="y">
      <el-input v-model="dataForm.y" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="z">
      <el-input v-model="dataForm.z" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="a">
      <el-input v-model="dataForm.a" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="b">
      <el-input v-model="dataForm.b" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="c">
      <el-input v-model="dataForm.c" placeholder=""></el-input>
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
          stationcode: '',
          x: '',
          y: '',
          z: '',
          a: '',
          b: '',
          c: '',
          time: ''
        },
        dataRule: {
          stationcode: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          x: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          y: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          z: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          a: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          b: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          c: [
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
              url: this.$http.adornUrl(`/ame_hdym/baseframe/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.stationcode = data.baseframe.stationcode
                this.dataForm.x = data.baseframe.x
                this.dataForm.y = data.baseframe.y
                this.dataForm.z = data.baseframe.z
                this.dataForm.a = data.baseframe.a
                this.dataForm.b = data.baseframe.b
                this.dataForm.c = data.baseframe.c
                this.dataForm.time = data.baseframe.time
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
              url: this.$http.adornUrl(`/ame_hdym/baseframe/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'stationcode': this.dataForm.stationcode,
                'x': this.dataForm.x,
                'y': this.dataForm.y,
                'z': this.dataForm.z,
                'a': this.dataForm.a,
                'b': this.dataForm.b,
                'c': this.dataForm.c,
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
